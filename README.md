[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title

LegacyLock - A dynamic Vault Management System

---

## Problem Statement (max 150 words)

In this digital era, individuals and families often struggle to securely store sensitive information, personal documents, and inheritance details in a way that is both accessible and trustworthy. Traditional methods such as paper records or scattered files are prone to loss, theft, or mismanagement, and they rarely provide a structured way to designate trusted nominees who can access this information when needed. LegacyLock addresses this gap by offering a secure, create personal vaults, assign nominees, and upload files. The system ensures persistence of data across sessions, meaning that vaults and user information remain intact even after the application is closed. By combining user management, vault ownership, nominee assignment, and file handling within a single platform, LegacyLock provides a practical solution for digital legacy planning and secure information sharing.

---

## Target User

- Individuals who want to securely store personal or family information.
- Users who need to designate nominees for digital assets.
- Students and developers learning basic OOP concepts in Java.

---

## Core Features

- Multi‑user registration, login, logout, and switching.
- Vault creation and viewing tied to active users.
- Nominee assignment with name, email, and relation.
- File upload placeholder for future expansion.
- Persistence of users and vaults across runs. 

---

## OOP Concepts Used

**Abstraction:** PersistenceManager hides save/load logic.  
**Inheritance:** GUI classes extend JFrame.  
**Polymorphism:** Overridden methods and flexible constructors.  
**Exception Handling:** Duplicate user registration handled with try/catch.  
**Collections / Threads:** ArrayList for users/vaults; shutdown hook thread for persistence.

---

## Proposed Architecture Description

LegacyLock follows a layered architecture to separate responsibilities and make the system easier to maintain and extend:

- **Model Layer (User, Vault, Nominee, VaultCondition):**  
  These classes represent the core entities of the system. By modeling users, vaults, and nominees as separate objects, we ensure that data is structured, reusable, and easy to persist. VaultCondition adds flexibility for future rules (e.g., time-based release).

- **Manager Layer (UserManager, VaultManager, SessionManager):**  
  Managers act as singletons that control collections of entities. UserManager ensures unique registration and retrieval of users, VaultManager handles vault creation and nominee assignment, and SessionManager tracks the active user. This centralization prevents duplication and enforces business rules consistently.

- **GUI Layer (DashboardGUI, NomineeGUI, FileUploadGUI, LoginGUI):**  
  Swing-based interfaces provide user interaction. Each GUI class extends `JFrame` to reuse window functionality and encapsulates its own logic. This separation makes the UI modular — changes in one screen don’t affect others.

- **Auth Layer (AuthService, PasswordHasher):**  
  Authentication ensures only valid users can log in. PasswordHasher abstracts hashing logic, improving security by avoiding plain-text storage. AuthService validates credentials against the UserManager.

- **Persistence Layer (PersistenceManager):**  
  Handles saving and loading of users and vaults using serialization. This abstraction hides file I/O details from the rest of the system, ensuring data survives across sessions without complicating business logic.

- **Main Application (LegacyLockApp):**  
  Acts as the entry point. It initializes persistence, ensures a Guest user exists, and launches the dashboard. This keeps startup logic centralized and clean.

**Reason for Using This Architecture specifically:**  
- Separation of concerns makes the system modular and easier to debug.  
- Managers enforce rules and prevent inconsistent state.  
- GUI classes remain lightweight and focused on interaction.  
- Persistence is abstracted so future storage methods can be added without changing core logic.  
- Overall, this design demonstrates key OOP principles while ensuring scalability and maintainability.

---

## How to Run

On Windows and Linux (Command Prompt):
1. Open Command Prompt
2. Navigate to project folder using `cd`
3. Compile all source files into the out folder: javac -d out src\main\*.java src\gui\*.java src\manager\*.java src\model\*.java src\auth\*.java src\persistence\*.java src\monitor\*.java
4. After compilation run the main class : java -cp out main.LegacyLockApp

---

## Git Discipline Notes
Minimum 10 meaningful commits required.
