# Genius CLI Music App

A lightweight command-line application for managing and exploring music content, built using Java and Maven. This project is designed for users, artists, and administrators to interact with songs, albums, and artist profiles entirely through a clean CLI interface.

## 🚀 Key Features

### User Management
- **User Roles**: Supports different roles including User, Artist, and Admin.
- **Login/Logout**: Real-time login/logout functionality without restarting the application.
- **Secure Authentication**: Passwords are securely hashed using SHA-256 with a unique salt derived from the user's ID.

### Preloaded Content (Seeding)
- Default data includes:
    - Admin account (Username: `admin`, Password: `admin`)
    - Sample artists, albums, and songs with links.

### User Features
- **Content Browsing**: Browse songs, albums, and artist profiles.
- **Engagement**: Comment on songs, view lyrics, suggest edits, and interact with comments (like, dislike, sad, laugh).
- **Artist Interaction**: Follow artists to stay updated with their content.

### Artist Features
- **Content Management**: Create and manage songs and albums.
- **Moderation**: Moderate user-submitted lyrics edits.
- **Song Stats**: Track metrics like views, likes, and comments for songs.

### UUID System
- Every entity (song, album, artist, etc.) is tagged with a UUID for reliable and consistent referencing.

### Centralized Routing System
- **Page Navigation**: Routes are managed in a centralized `Router`, allowing smooth navigation between CLI pages.
- **History & Back Navigation**: A stack-based system allows "back" navigation and optional control of page history.
- **Access Control**: Each page has unique route strings and access control for secure navigation.

### Application Setup
- **Bootstrapper**: The app is initialized through a single Application class that provides methods like `Create()` or `CreateDefault()`.
- **Modular Setup**: Routes are configured during startup, enabling extensibility and easy integration of new features.

### Session Management
- **Active Session**: A singleton session object keeps track of the logged-in user.

### Dynamic Routing and Form Handling
- **Route Binding**: Pages are registered dynamically during setup, supporting easy extensions with new routes or features.
- **Dynamic Form Handling**: Fields marked with the `@UserInput` annotation are automatically included in the form and can be populated based on user input.
- **Field Validation**: Ensures required fields (marked with `@UserInput(required = true)`) are validated and not left empty.
- **Default Value Support**: In edit mode, fields display their current value, which can either be updated or retained by the user.
- **Type Handling**: Automatically handles different data types like `String`, `int`, `boolean`, `double`, and `LocalDateTime`.

### Helper Class
- **Route Parameter Helper**: The `RouteParameterHelper` class ensures safe extraction of route parameters with specified types and default values.

## Design Patterns Used

- **Singleton Pattern**: Used in `Router` and `Session` to ensure a single instance across the application.
- **Factory Method Pattern**: Used for creating configured instances like `Application.Create()`.
- **Strategy Pattern**: Encapsulates different behaviors for user roles (`Artist`, `User`, `Admin`).
- **Template Method Pattern**: The `Page` class defines common flows with hooks for custom logic.
- **Command Pattern**: Actions like navigating menus are treated as commands, facilitating scalability and customization.
- **Repository Pattern**: Abstracts data persistence layers (e.g., `ArtistService`, `SongService`).
- **Unit of Work Pattern**: Centralizes services to ensure consistency across operations.

The project follows Object-Oriented Programming principles and adheres to SOLID principles, ensuring maintainability and scalability.

## 🧠 Project Structure

- **Entities (`com.genius.Entities`)**: Contains models like Account, Song, Album, ArtistProfile.
- **Services (`com.genius.Services`)**: Contains business logic and validation services.
- **CLI Pages (`com.AP.Pages`)**: Manages UI logic and rendering of menus.
- **Router (`com.AP.Router`)**: Handles page transitions and navigation history.

## 🔧 Requirements

- Java 21+
- Git
