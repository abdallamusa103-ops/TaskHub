package com.abdallamusa.taskhub.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.abdallamusa.taskhub.data.local.TaskDatabase.Companion.getTaskDatabase
import com.abdallamusa.taskhub.data.model.Priority
import com.abdallamusa.taskhub.data.model.Task
import com.abdallamusa.taskhub.data.repository.TaskRepositoryImpl
import com.abdallamusa.taskhub.domain.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

data class TaskState(


    val currentTask: Task = Task(title = "", description = "", dueDate = ""),
    val isEditing: Boolean = false
)


class TaskViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val taskRepository: TaskRepository by lazy {
        val database = getTaskDatabase(application)
        TaskRepositoryImpl(database.getTaskDao())
    }

    private val _taskState = MutableStateFlow(TaskState())
    val taskState: StateFlow<TaskState> = _taskState.asStateFlow()

    val tasks: StateFlow<List<Task>> = taskRepository.getAllTasks()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )


    fun prepForAddTask() {
        _taskState.update { currentTaskState ->
            currentTaskState.copy(
                currentTask = Task(title = "", description = "", dueDate = ""),
                isEditing = false
            )
        }
    }

    fun prepForEditTask(taskId: String) {

        val currentEditedTask = tasks.value.find { it.id == taskId }

        if (currentEditedTask != null)
            _taskState.update { currentTaskState ->
                currentTaskState.copy(
                    currentTask = currentEditedTask,
                    isEditing = true
                )

            }

    }

    fun deleteTask(task: Task) {

        viewModelScope.launch {
            taskRepository.deleteTask(task = task)

        }
        prepForAddTask()
    }

    fun updateTaskTitle(newTitle: String) {

        _taskState.update { currentTaskState ->
            currentTaskState.copy(
                currentTask = currentTaskState.currentTask.copy(title = newTitle)
            )

        }
    }

    fun updateTaskDescription(newDescription: String) {
        _taskState.update { currentTaskState ->
            currentTaskState.copy(
                currentTask = currentTaskState.currentTask.copy(description = newDescription)
            )

        }
    }

    fun updateTaskPriority(newPriority: Priority) {
        _taskState.update { currentTaskState ->
            currentTaskState.copy(
                currentTask = currentTaskState.currentTask.copy(priority = newPriority)
            )

        }
    }

    fun updateTaskDueDate(newDateMillis: Long?) {
// MMM -> for short text month
        newDateMillis?.let {
            val formatter = SimpleDateFormat("MMM dd,yyyy", Locale.getDefault())

            val formattedSelectedDate = formatter.format(newDateMillis)

            _taskState.update { currentTaskState ->
                currentTaskState.copy(
                    currentTask = currentTaskState.currentTask.copy(dueDate = formattedSelectedDate)
                )

            }

        }

    }

    fun saveTask() {

        val currentTask = _taskState.value.currentTask
        val isEditing = _taskState.value.isEditing

        viewModelScope.launch {
            if (isEditing) {
                taskRepository.updateTask(currentTask)
            } else {
                taskRepository.addTask(currentTask)
            }
        }
        prepForAddTask()
    }

    fun deleteAllTasks() {

        viewModelScope.launch {
            taskRepository.deleteAllTasks()
        }

    }

}