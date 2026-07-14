package com.abdallamusa.taskhub.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abdallamusa.taskhub.data.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insetTask()

//    @Query("SELECT * FROM tasks")
//     fun getAllTasks(): Flow<List<Task>>

}