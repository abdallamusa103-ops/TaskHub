package com.abdallamusa.taskhub.data.local.converters

import androidx.room.TypeConverter
import com.abdallamusa.taskhub.data.model.Priority

class PriorityConverter {

    @TypeConverter
    fun fromPriority(priority: Priority): String = priority.label

    @TypeConverter
    fun toPriority (priorityLabel :String) : Priority {

        return Priority.entries.find { it.label == priorityLabel } ?: Priority.LOW
    }


}