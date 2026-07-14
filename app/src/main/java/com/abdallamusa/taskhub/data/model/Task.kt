package com.abdallamusa.taskhub.data.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import com.abdallamusa.taskhub.ui.theme.PriorityHighContainer
import com.abdallamusa.taskhub.ui.theme.PriorityHighText
import com.abdallamusa.taskhub.ui.theme.PriorityLowContainer
import com.abdallamusa.taskhub.ui.theme.PriorityLowText
import com.abdallamusa.taskhub.ui.theme.PriorityMediumContainer
import com.abdallamusa.taskhub.ui.theme.PriorityMediumText
import java.util.UUID


data class Task(
    val id:String = UUID.randomUUID().toString(),
    val title:String,
    val description: String,
    val dueDate:String ,
    val priority: Priority = Priority.LOW
)

enum class Priority (val label:String , val textColor: Color , val containerColor : Color){
    HIGH("High" , textColor = PriorityHighText , containerColor = PriorityHighContainer),
    MEDIUM("Medium" , textColor = PriorityMediumText , containerColor = PriorityMediumContainer),
    LOW("Low", textColor = PriorityLowText , containerColor = PriorityLowContainer)
}