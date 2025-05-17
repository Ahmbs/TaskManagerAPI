# Project Summary

## Overview
The project is a Task Manager API developed using Java. It employs the Spring framework for building the backend and utilizes various libraries for security, data management, and RESTful services. The purpose of the project is to provide a robust API for managing tasks, user authentication, and authorization.

### Languages, Frameworks, and Main Libraries Used
- **Language**: Java
- **Framework**: Spring (Spring Boot)
- **Build Tool**: Maven
- **Other Libraries**: 
  - Spring Security (for authentication and authorization)
  - JPA (Java Persistence API for database interactions)

## Purpose of the Project
The Task Manager API aims to facilitate task management functionalities, allowing users to create, update, delete, and retrieve tasks. It also includes user authentication and registration features to secure access to the API.

## Build and Configuration Files
- **Maven Wrapper**: 
  - `/mvnw`
  - `/mvnw.cmd`
- **Maven Project File**: 
  - `/pom.xml`
- **Package Configuration**: 
  - `/package.json` (if applicable for front-end or additional tooling)

## Source Files Location
The source files are located in the following directory:
- `/src/main/java/com/example/TaskManagerAPI`

### Subdirectories for Source Files
- **Infra/security**: 
  - `/src/main/java/com/example/TaskManagerAPI/Infra/security/`
    - `CustomUserDetailsService.java`
    - `SecurityConfig.java`
    - `SecurityFilter.java`
    - `TokenService.java`
    - `TaskManagerApiApplication.java`
- **Controller**: 
  - `/src/main/java/com/example/TaskManagerAPI/controller/`
    - `AuthController.java`
    - `TaskController.java`
    - `UserController.java`
- **DTO**: 
  - `/src/main/java/com/example/TaskManagerAPI/dto/`
    - `LoginRequestDTO.java`
    - `RegisterRequestDTO.java`
    - `ResponseDTO.java`
    - `TaskDTO.java`
- **Model**: 
  - `/src/main/java/com/example/TaskManagerAPI/model/`
    - `Task.java`
    - `User.java`
- **Repository**: 
  - `/src/main/java/com/example/TaskManagerAPI/repository/`
    - `TaskRepository.java`
    - `TaskSpecifications.java`
    - `UserRepository.java`

## Documentation Files Location
- **Help Documentation**: 
  - `/HELP.md`
- **Project Readme**: 
  - `/README.md`
- **Configuration Properties**: 
  - `/src/main/resources/application.properties`