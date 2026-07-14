package com.abdallamusa.taskhub.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.abdallamusa.taskhub.data.dummydata.sampleTasks
import com.abdallamusa.taskhub.data.model.Priority
import com.abdallamusa.taskhub.data.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Locale

data class TaskState(
    val tasks: List<Task> = emptyList(),

    val currentTask: Task = Task(title = "", description = "", dueDate = "") ,
   val isEditing : Boolean = false
)

class TaskViewModel : ViewModel() {

    private val _taskState = MutableStateFlow(TaskState())
    val taskState: StateFlow<TaskState> = _taskState.asStateFlow()

    init {
        _taskState.update { it.copy(tasks = sampleTasks()) }
    }

    fun prepForAddTask() {
        _taskState.update { currentTaskState ->
            currentTaskState.copy(
                currentTask = Task(title = "", description = "", dueDate = "") ,
                isEditing = false
            )
        }
    }

    fun prepForEditTask(taskId: String) {

        val currentEditedTask = _taskState.value.tasks.find { it.id == taskId }
        if (currentEditedTask != null)
            _taskState.update { currentTaskState ->
                currentTaskState.copy(
                    currentTask = currentEditedTask ,
                    isEditing = true
                )

            }

    }

    fun deleteTask(taskId: String) {

        _taskState.update {currentTaskState ->
            currentTaskState.copy(
                tasks = currentTaskState.tasks.filterNot { taskId == it.id },
                currentTask = Task(title = "" , description =  "" , dueDate = "" )
            )

        }
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

    fun updateTaskDueDate(newDateMillis :Long?){
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
        _taskState.update { currentTaskState ->
            val currentTask = currentTaskState.currentTask

            val taskExisted = currentTaskState.tasks.any { it.id == currentTask.id }

            val updatedTasks = if (taskExisted) {

                currentTaskState.tasks.map {
                    if (it.id == currentTask.id) currentTask else it
                }
            } else {
                currentTaskState.tasks + currentTask
            }

            currentTaskState.copy(
                tasks = updatedTasks,
                currentTask = Task(title = "", description = "", dueDate = "")
            )


        }
    }

    fun deleteAllTasks() {

        _taskState.update {currentTaskState ->
            currentTaskState.copy(
                tasks = emptyList(),
                currentTask = Task(title = "", description = "", dueDate = "")
            )

        }

    }

}