package com.abdallamusa.taskhub.domain

import com.abdallamusa.taskhub.data.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository  {
    suspend fun updateTask(task: Task)
    suspend fun deleteAllTasks()
    suspend fun addTask(task: Task)
    suspend fun deleteTask(task: Task)
     fun getAllTasks() : Flow<List<Task>>


}