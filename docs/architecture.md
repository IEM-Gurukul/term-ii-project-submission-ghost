# LegacyLock – Design Document

## System Overview
LegacyLock is a Java desktop application that allows multiple users to register, create vaults, assign nominees, and upload files. It uses a layered architecture to separate concerns and demonstrate OOP principles.

## Design Goals
- Secure storage of user and vault data.
- Clear separation of responsibilities (Model, Manager, GUI, Auth, Persistence).
- Persistence across sessions using serialization.
- Extensible design for future features (file storage, advanced conditions).

## Architecture Layers and Rationale

- **Model Layer (User, Vault, Nominee, VaultCondition):**  
  Encapsulates core data. We use this layer to ensure entities are reusable, structured, and easy to persist. VaultCondition adds flexibility for future rules like time‑based release.

- **Manager Layer (UserManager, VaultManager, SessionManager):**  
  Managers are singletons that centralize business logic. This prevents duplication and enforces consistency. For example, UserManager ensures unique registration, VaultManager handles vault creation and nominee assignment, and SessionManager tracks the active user.

- **GUI Layer (DashboardGUI, NomineeGUI, FileUploadGUI, LoginGUI):**  
  Swing interfaces provide user interaction. Each GUI class extends `JFrame` to reuse window functionality. This modular design keeps UI logic separate from data and business rules.

- **Auth Layer (AuthService, PasswordHasher):**  
  Authentication ensures only valid users can log in. PasswordHasher abstracts hashing logic, improving security by avoiding plain‑text storage. AuthService validates credentials against UserManager.

- **Persistence Layer (PersistenceManager):**  
  Handles saving and loading of users and vaults using serialization. Abstracting persistence allows us to change storage (e.g., move to a database) without altering business logic.

- **Main Application (LegacyLockApp):**  
  Entry point that initializes persistence, ensures a Guest user exists, and launches the dashboard. Centralizing startup logic keeps the system clean and maintainable.

## UML Diagrams
- **Class Diagram:** Shows relationships between User, Vault, Nominee, and managers.
- **Use Case Diagram:** Illustrates user interactions (register, login, create vault, assign nominee).
- **Sequence Diagram:** Demonstrates flow of login and vault creation.

## Why This Architecture?
- Separation of concerns makes the system modular and easier to debug.  
- Managers enforce rules and prevent inconsistent state.  
- GUI classes remain lightweight and focused on interaction.  
- Persistence is abstracted so future storage methods can be added easily.  
- Overall, this design demonstrates key OOP principles (abstraction, inheritance, polymorphism) while ensuring scalability and maintainability.
