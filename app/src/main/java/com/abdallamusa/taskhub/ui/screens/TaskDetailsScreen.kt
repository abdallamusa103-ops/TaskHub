package com.abdallamusa.taskhub.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.abdallamusa.taskhub.data.model.Task
import com.abdallamusa.taskhub.ui.components.ConfirmDialog
import com.abdallamusa.taskhub.ui.components.TaskDetailedCard

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskDetailsScreen(
    task: Task,
    onClickBack: () -> Unit,
    onEditClick: () -> Unit,
    onDeleteTaskClick: () -> Unit
) {
    var showDeleteDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack Icon"
                        )
                    }
                },
                title = {
                    Text(
                        text = "Task Details",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Normal
                    )
                },
                actions = {
                    IconButton(onEditClick) {
                        Icon(Icons.Outlined.Edit, contentDescription = "Edit Pencil Icon")
                    }
                    //to open the dialog
                    IconButton(onClick = { showDeleteDialog = true }) {

                        Icon(Icons.Outlined.Delete, contentDescription = "Edit Pencil Icon")
                    }
                }
            )
        }

    ) {innerPadding ->
        if (showDeleteDialog) {
            ConfirmDialog(
                title = "Delete Task?",
                message = "\"${task.title}\" Will be Permanently removed. ",
                onConfirm = {
                    onDeleteTaskClick()
                    showDeleteDialog = false
                },
                onDismiss = {
                    showDeleteDialog = false
                }

            )
        }
       Box(modifier = Modifier.padding(innerPadding)) {
            TaskDetailedCard(task = task)
        }

    }


}