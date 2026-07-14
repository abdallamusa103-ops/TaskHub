package com.abdallamusa.taskhub

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.abdallamusa.taskhub.ui.navigation.TaskNavGraph
import com.abdallamusa.taskhub.ui.screens.TaskListScreen
import com.abdallamusa.taskhub.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MyApplicationTheme {

                TaskNavGraph(navController)
            }
        }
    }
}

