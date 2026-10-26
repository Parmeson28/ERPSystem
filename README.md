# ERPSystem

An ERP (Enterprise Resource Planning) system for storing **technical drawings** and managing **stock**.

> **Status: work in progress.** The project is still under development. Features, structure and setup steps may change, and some parts are not implemented yet.

## About

ERPSystem is a Java application that centralizes two things a small manufacturing or workshop business needs to keep organized:

- **Technical drawings**: store and keep track of drawings in one place instead of scattered files.
- **Stock**: register products and control what is available.

Product data is persisted in a relational database (see `ERPConnection.session.sql`, which queries the `produtos` table).

## Tech Stack

- **Language:** Java
- **Build tool:** Gradle (with the Gradle Wrapper)
- **Database:** SQL (relational)
- **Editor config:** VS Code (`.vscode/`)

## Project Structure

```
ERPSystem/
├── app/                        # Main application module (source code)
├── gradle/                     # Gradle wrapper files
├── .vscode/                    # VS Code settings
├── ERPConnection.session.sql   # SQL session file for querying the database
├── gradle.properties
├── gradlew / gradlew.bat       # Gradle wrapper scripts (Linux/macOS / Windows)
└── settings.gradle
```

## Getting Started

### Prerequisites

- JDK (Java Development Kit), version 17 or newer recommended
- A running SQL database (configure the connection in the app, see below)
- Git

### Clone the repository

```bash
git clone https://github.com/Parmeson28/ERPSystem.git
cd ERPSystem
```

### Database setup

1. Create a database for the project.
2. Create the required tables (for example, the `produtos` table).
3. Set your connection details (URL, user, password) in the application's configuration.

> The schema is still evolving. A full setup script will be added once the data model is stable.

### Build and run

Linux / macOS:

```bash
./gradlew build
./gradlew run
```

Windows:

```bash
gradlew.bat build
gradlew.bat run
```

## Roadmap

- [x] Project setup with Gradle
- [x] Database connection
- [x] Stock management (add, edit, remove, list products)
- [ ] Technical drawing storage and retrieval
- [x] Search and filtering
- [x] User interface
- [ ] Authentication and permissions
- [ ] Documentation and database setup script

## Contributing

This is a personal project in early development. Suggestions and feedback are welcome through issues.

## Author

**Tiago**: [GitHub](https://github.com/Parmeson28)

## License

No license has been defined yet.
