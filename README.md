# TaskHub

TaskHub is a modern, lightweight Android task management application built entirely with Jetpack Compose. This project focuses on demonstrating modern Android architecture, robust state management, and high-performance, modular UI design.

---

## 🛠 Tech Stack
This project leverages the latest standard tools and libraries recommended for modern Android development:
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose (Material Design 3)
- **Navigation**: Navigation Compose
- **Local Persistence**: Room Database (with Kotlin Symbol Processing - KSP)
- **Asynchrony**: Kotlin Coroutines & StateFlow/SharedFlow
- **Architecture**: MVVM with Clean Code principles

---

## 🏗 Architecture & Best Practices

### 1. Shared ViewModel Strategy
To ensure a **Single Source of Truth** and seamless data synchronization across different screens, TaskHub utilizes a **Shared ViewModel**. 
- Instead of instantiating multiple ViewModels for tightly coupled screens (like a list screen and a detail screen), the shared ViewModel is scoped to the navigation graph.
- **Why?** It guarantees that when a task is updated on one screen, the change is immediately reflected on all other screens without needing complex callbacks or extra database reads.

### 2. State Hoisting
We adhere strictly to the concept of **State Hoisting** to make our UI components stateless and highly reusable.
- **Data flows down, Events flow up**: Composables are not responsible for managing their own complex business state. State variables and lambda callbacks are passed down from the parent (usually the screen-level Composable hooked to the ViewModel).
- This makes individual UI components easily testable and decoupled from the ViewModel layer.

### 3. UI Component Breakdown (Modular UI)
To optimize rendering performance and prevent unnecessary recompositions, the UI is heavily modularized:
- **Granular Components**: Complex screens are broken down into smaller, focused Composables (e.g., `TaskListItem`, `EmptyStateView`, `CustomTopAppBar`).
- **Flat Layouts**: We avoid deep nesting of `Columns` and `Rows` wherever possible, ensuring a shallow and performant View hierarchy. 
- By keeping components small, Jetpack Compose can intelligently skip recomposing elements that haven't changed.

### 4. Naming Conventions
A consistent naming convention is vital for the scannability of the codebase:
- **Composables**: Always use `PascalCase` and use noun-phrases (e.g., `TaskListScreen`, `SaveButton`).
- **Variables/Functions**: Use `camelCase` (e.g., `onTaskClick`, `taskTitle`).
- **State/Flows**: Backing properties are prefixed with an underscore (e.g., `_uiState` as a `MutableStateFlow` and `uiState` as an immutable `StateFlow` exposed to the UI).

### 5. Clean Code & SOLID Principles
Code readability and maintainability are prioritized over "clever" one-liners:
- **Separation of Concerns**: The UI is strictly dumb; all business logic, validation, and data formatting happen in the ViewModel or Domain layer.
- **Self-Documenting**: Functions and variables are named descriptively so that the code reads naturally without requiring excessive, redundant comments.
- **Resource Discipline**: We ensure our Coroutines are properly scoped to the `viewModelScope` to prevent memory leaks, and Room streams are properly collected in a lifecycle-aware manner using `collectAsStateWithLifecycle()`.

---

> **Note:** This project is intentionally built as a showcase for architectural best practices, clean design, and efficient resource usage in a modern Android ecosystem.
