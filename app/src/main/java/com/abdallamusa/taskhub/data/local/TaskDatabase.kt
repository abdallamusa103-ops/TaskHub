package com.abdallamusa.taskhub.data.local

import androidx.room.Database
import androidx.room.Entity
import androidx.room.InvalidationTracker
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase


    @Entity
    data class DummyEntity(@PrimaryKey val id: Int = 1)
@Database(entities = [DummyEntity::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {



}