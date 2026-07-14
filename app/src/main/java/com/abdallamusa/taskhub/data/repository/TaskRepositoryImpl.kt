package com.abdallamusa.taskhub.data.repository

import com.abdallamusa.taskhub.data.local.TaskDao
import com.abdallamusa.taskhub.data.model.Task
import com.abdallamusa.taskhub.domain.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val taskDao: TaskDao
) : TaskRepository {
    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    override suspend fun addTask(task: Task) {
        taskDao.insertTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

    override fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()
    override suspend fun deleteAllTasks() {
        taskDao.deleteAllTasks()
    }
}