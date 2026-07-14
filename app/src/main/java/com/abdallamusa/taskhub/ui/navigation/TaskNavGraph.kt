package com.abdallamusa.taskhub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.abdallamusa.taskhub.ui.screens.TaskDetailsScreen
import com.abdallamusa.taskhub.ui.screens.TaskFormScreen
import com.abdallamusa.taskhub.ui.screens.TaskListScreen
import com.abdallamusa.taskhub.ui.viewmodel.TaskViewModel

@Composable
fun TaskNavGraph(
    navController: NavHostController
) {

    val sharedTaskViewModel: TaskViewModel = viewModel()
    val uiState by sharedTaskViewModel.taskState.collectAsState()


    NavHost(navController = navController, startDestination = Routes.TASK_LIST) {

//Declare All Screens Of the App

        composable(Routes.TASK_LIST) {
            TaskListScreen(
                tasks = uiState.tasks,
                onTaskClick = { clickedTask ->

                    // send task to the Task Details Screen
                    navController.navigate(Routes.taskDetailsRoute(clickedTask.id))

                },
                onAddTaskClick = {
                    //to prepare for  a new fresh task
                    sharedTaskViewModel.prepForAddTask()

                    navController.navigate(Routes.TASK_FORM)
                },
                onClearAllTasks = { sharedTaskViewModel.deleteAllTasks() }


            )
        }

        composable(Routes.TASK_FORM) {
            TaskFormScreen(

                isEditingMode = uiState.isEditing,
                task = uiState.currentTask,
                onTitleChange = { sharedTaskViewModel.updateTaskTitle(it) },
                onDescriptionChange = { sharedTaskViewModel.updateTaskDescription(it) },
                onPrioritySelected = { sharedTaskViewModel.updateTaskPriority(it) },
                onDueDateChange = { sharedTaskViewModel.updateTaskDueDate(it) },
                onSaveClick = {
                    sharedTaskViewModel.saveTask()
                    navController.navigate(Routes.TASK_LIST) {

                        popUpTo(Routes.TASK_LIST) { inclusive = true }

                    }
                }
                , onClickBack = {
                    navController.navigate(Routes.TASK_LIST)
                }


            )
        }

        composable(
            Routes.TASK_DETAILS_WITH_TASK_ID,
            arguments = listOf(
                navArgument(name = "taskId") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->



            val extractedId = navBackStackEntry.arguments?.getString("taskId")

            val taskToShow = uiState.tasks.find { it.id == extractedId }

            if (taskToShow != null) {
                TaskDetailsScreen(

                    task = taskToShow,

                    onClickBack = {
                        navController.navigate(Routes.TASK_LIST) {
                            popUpTo(Routes.TASK_LIST) { inclusive = true }
                        }
                    },
                    onEditClick = {
                        extractedId?.let { id -> sharedTaskViewModel.prepForEditTask(id) }

                        navController.navigate(Routes.TASK_FORM)

                    },
                    onDeleteTaskClick = {
                        extractedId?.let { id -> sharedTaskViewModel.deleteTask(id) }
                        navController.navigate(Routes.TASK_LIST) {
                            popUpTo(Routes.TASK_LIST) { inclusive = true }
                        }
                    }

                )
            }
        }

    }

}