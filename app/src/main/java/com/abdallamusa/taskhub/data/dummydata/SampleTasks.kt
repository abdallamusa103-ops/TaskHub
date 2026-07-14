package com.abdallamusa.taskhub.data.dummydata

import com.abdallamusa.taskhub.data.model.Priority
import com.abdallamusa.taskhub.data.model.Task

fun sampleTasks(): List<Task> {
    return listOf(
        // The 4 tasks from your UI mockup
        Task(
            title = "Read Compose documentation",
            description = "Go through the official Jetpack Compose tutorials and codelabs.",
            dueDate = "Jul 8, 2026",
            priority = Priority.HIGH
        ),
        Task(
            title = "Set up Git branch",
            description = "Create a feature branch and push your first commit.",
            dueDate = "Jul 7, 2026",
            priority = Priority.MEDIUM
        ),
        Task(
            title = "Pair with mentor",
            description = "Schedule a 30-minute session to review project structure.",
            dueDate = "Jul 10, 2026",
            priority = Priority.LOW
        ),
        Task(
            title = "Fix first bug",
            description = "Pick a small bug from the backlog and submit a PR.",
            dueDate = "Jul 12, 2026",
            priority = Priority.HIGH
        ),

        // 16 additional themed tasks for testing the LazyColumn
        Task(
            title = "Implement LazyColumn",
            description = "Replace the standard Column with a LazyColumn to optimize list rendering.",
            dueDate = "Jul 13, 2026",
            priority = Priority.MEDIUM
        ),
        Task(
            title = "Refactor ViewModel",
            description = "Ensure StateFlow is properly encapsulated using a private MutableStateFlow.",
            dueDate = "Jul 14, 2026",
            priority = Priority.HIGH
        ),
        Task(
            title = "Update Material Design",
            description = "Apply Material 3 typography and color schemes to the main screen.",
            dueDate = "Jul 15, 2026",
            priority = Priority.LOW
        ),
        Task(
            title = "Write Unit Tests",
            description = "Add basic JUnit tests for the Task sorting and filtering logic.",
            dueDate = "Jul 16, 2026",
            priority = Priority.MEDIUM
        ),
        Task(
            title = "Daily Team Standup",
            description = "Join the Google Meet at 10:00 AM for the daily sync.",
            dueDate = "Jul 10, 2026",
            priority = Priority.HIGH
        ),
        Task(
            title = "Code Review",
            description = "Review PR #42 from the senior developer and leave comments.",
            dueDate = "Jul 11, 2026",
            priority = Priority.MEDIUM
        ),
        Task(
            title = "Design Database Schema",
            description = "Draft the Room database entities for local data caching.",
            dueDate = "Jul 18, 2026",
            priority = Priority.HIGH
        ),
        Task(
            title = "Fix UI Overlap",
            description = "Resolve the overlapping text issue on smaller screen sizes.",
            dueDate = "Jul 11, 2026",
            priority = Priority.HIGH
        ),
        Task(
            title = "Learn Coroutines",
            description = "Read chapter 4 of Kotlin Coroutines to understand background threading.",
            dueDate = "Jul 17, 2026",
            priority = Priority.LOW
        ),
        Task(
            title = "Update README",
            description = "Document the new setup instructions and architecture details.",
            dueDate = "Jul 14, 2026",
            priority = Priority.LOW
        ),
        Task(
            title = "Implement Search Bar",
            description = "Add a text field at the top of the screen to filter tasks by title.",
            dueDate = "Jul 20, 2026",
            priority = Priority.MEDIUM
        ),
        Task(
            title = "Optimize App Startup",
            description = "Profile the app startup time using Android Studio Profiler.",
            dueDate = "Jul 22, 2026",
            priority = Priority.MEDIUM
        ),
        Task(
            title = "Setup GitHub Actions",
            description = "Configure a basic CI pipeline to run tests on every push.",
            dueDate = "Jul 25, 2026",
            priority = Priority.HIGH
        ),
        Task(
            title = "Accessibility Audit",
            description = "Ensure all interactive elements have proper content descriptions for screen readers.",
            dueDate = "Jul 21, 2026",
            priority = Priority.MEDIUM
        ),
        Task(
            title = "Prepare Sprint Demo",
            description = "Gather screenshots and bullet points for the Friday sprint review.",
            dueDate = "Jul 17, 2026",
            priority = Priority.HIGH
        ),
        Task(
            title = "Coffee Break",
            description = "Join the virtual watercooler chat to meet the design team.",
            dueDate = "Jul 12, 2026",
            priority = Priority.LOW
        )
    )
}