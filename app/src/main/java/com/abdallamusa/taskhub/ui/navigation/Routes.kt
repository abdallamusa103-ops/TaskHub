package com.abdallamusa.taskhub.ui.navigation

object Routes {

    const val TASK_LIST = "taskListScreen"
    const val TASK_DETAILS_WITH_TASK_ID = "taskDetailsScreen/{taskId}"
    const val TASK_FORM= "taskFormScreen"

    fun taskDetailsRoute(taskId: String) = "taskDetailsScreen/$taskId"

}