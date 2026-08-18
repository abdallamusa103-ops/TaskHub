# TaskHub

TaskHub is a modern, lightweight Android task management application built entirely with Jetpack Compose. This project focuses on demonstrating modern Android architecture, robust state management, and high-performance, modular UI design.

> **Note:** This project is intentionally built as a showcase for architectural best practices, clean design, and efficient resource usage in a modern Android ecosystem.

## 🛠 Tech Stack

*   **Language:** Kotlin
*   **UI Framework:** Jetpack Compose (Material Design 3)
*   **Navigation:** Navigation Compose
*   **Local Persistence:** Room Database (with Kotlin Symbol Processing - KSP)
*   **Asynchrony:** Kotlin Coroutines, StateFlow, SharedFlow
*   **Architecture:** MVVM with Clean Code principles

## 🏗 Architecture & Best Practices

### System Architecture Diagram

```mermaid
graph TD
  subgraph UI Layer
    A[Task Screens / Composables] -->|User Intents| B(Shared TaskViewModel)
    B -->|StateFlow / UI State| A
  end
  subgraph Domain Layer
    B -->|CRUD Operations| C{TaskRepository Interface}
  end
  subgraph Data Layer
    C --- D[TaskRepositoryImpl]
    D -->|Room DAO Queries| E[(SQLite Database)]
    E -->|Flow Updates| D
  end
