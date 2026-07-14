package com.abdallamusa.taskhub.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.abdallamusa.taskhub.data.model.Task
import com.abdallamusa.taskhub.ui.components.ConfirmDialog
import com.abdallamusa.taskhub.ui.components.EmptyTasksScreen
import com.abdallamusa.taskhub.ui.components.TaskCard
import com.abdallamusa.taskhub.ui.theme.PrimaryBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(
    tasks: List<Task>,
    onClearAllTasks: () -> Unit,
    onAddTaskClick: () -> Unit,
    onTaskClick: (Task) -> Unit
) {

    var menuExpanded by remember { mutableStateOf(false) }
    var showConfirmDialog by remember { mutableStateOf(false) }




    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Task List",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                actions = {
                    IconButton(onClick = {
                        menuExpanded = true

                    }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Icon of Top bar Menu")

                    }
                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }
                    ) {

                        DropdownMenuItem(
                            text = { Text(text = "Clear All") },
                            onClick = {
                                showConfirmDialog = true
                            }

                        )
                    }

                }


            )


        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddTaskClick() },
                containerColor = PrimaryBlue,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Task Icon")

            }
        }

    ) { innerPadding ->
        if (showConfirmDialog) {
            ConfirmDialog(
                title = "Confirm Clear All",
                message = "Are you sure you want to clear all tasks?",
                onConfirm = {
                    onClearAllTasks()
                    showConfirmDialog = false
                },
                onDismiss = {
                    showConfirmDialog = false
                }

            )
        }

        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(10.dp)
        ) {

            if (tasks.isEmpty()) {
                item {
                    EmptyTasksScreen()
                }
            }
            items(items = tasks) { singleTask ->

                TaskCard(task = singleTask, onTaskClick = { onTaskClick(singleTask) })

            }
        }

    }


}