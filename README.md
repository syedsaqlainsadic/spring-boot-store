# 🛒 Spring Boot Store API

A production-style **E-Commerce Store Backend** built using **Java, Spring Boot, Spring Security, JWT Authentication, MySQL, Flyway, and Railway**.

This project demonstrates how to design, develop, secure, and deploy a scalable RESTful backend application following industry best practices and layered architecture.

---

## 🚀 Live Demo

**Swagger UI**

> (https://store-api-production-1c2e.up.railway.app/swagger-ui/index.html#/order-controller)


---

## 📌 Project Overview

The Store API provides a complete backend solution for an online shopping application. It includes secure authentication, user management, product management, shopping cart operations, and cloud deployment.

The application follows a layered architecture and demonstrates clean code principles, RESTful API design, database migrations, and secure authentication using JWT.

---

# ✨ Features

## 👤 Authentication

- User Registration
- User Login
- JWT Authentication
- BCrypt Password Encryption
- Protected Endpoints

---

## 👥 User Management

- Create User
- View User
- Update User
- Delete User

---

## 🏠 Address Management

- Add Address
- Update Address
- Delete Address
- Retrieve User Addresses

---

## 👤 Profile Management

- Create Profile
- Update Profile
- Retrieve Profile

---

## 🛍 Product Management

- Create Product
- Update Product
- Delete Product
- View Products
- Search Products

---

## 📂 Category Management

- Create Categories
- Retrieve Categories
- Update Categories
- Delete Categories

---

## 🛒 Shopping Cart

- Create Cart
- Add Products
- Remove Products
- View Cart

---

## 🔐 Security

- Spring Security
- JWT Authentication
- Password Encryption
- Protected REST APIs

---

## 🗄 Database

- MySQL
- Spring Data JPA
- Hibernate ORM
- Flyway Database Migration

---

# 🏗 Architecture

The application follows a layered architecture.

```
                Client
                   │
                   ▼
          REST Controllers
                   │
                   ▼
            Service Layer
                   │
                   ▼
         Repository Layer
                   │
                   ▼
              MySQL Database
```

Project Structure

```
src
├── config
├── controllers
├── dto
├── entities
├── exceptions
├── mappers
├── repositories
├── security
├── services
├── utils
└── resources
      ├── application.yml
      └── db
          └── migration
```

---

# 🛠 Tech Stack

### Backend

- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate

### Database

- MySQL

### Authentication

- JWT (JSON Web Token)

### Database Migration

- Flyway

### Documentation

- Swagger / OpenAPI

### Build Tool

- Maven

### Deployment

- Railway

### Version Control

- Git
- GitHub

---

# 📖 API Documentation

After running the application, open

```
http://localhost:8080/swagger-ui/index.html
```

or

```
https://YOUR-RAILWAY-URL.up.railway.app/swagger-ui/index.html
```

Swagger provides interactive API documentation where every endpoint can be tested directly from the browser.

---

# ⚙ Running the Project

## Clone Repository

```bash
git clone https://github.com/syedsaqlainsadic/spring-boot-store.git
```

---

## Navigate

```bash
cd spring-boot-store
```

---

## Configure Database

Update the database configuration in

```
application.yml
```

Example

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/store
    username: root
    password: password
```

---

## JWT Secret

Configure your JWT secret.

Example

```
JWT_SECRET=YOUR_SECRET_KEY
```

---

## Run

```bash
mvn spring-boot:run
```

or

Run directly from your IDE.

---

# 🗃 Database Migration

This project uses **Flyway** to automatically manage database schema versions.

Migration scripts are located in:

```
src/main/resources/db/migration
```

Database tables are automatically created when the application starts.

---

# 🌍 Deployment

The application is deployed on **Railway**.

Deployment includes:

- Cloud-hosted Spring Boot application
- Railway MySQL database
- Automatic Flyway migrations
- Environment variable configuration
- Continuous deployment from GitHub

---

# 📸 Screenshots

Consider adding screenshots of:

- Swagger UI
- Railway Deployment
- GitHub Repository
- Database Tables
- API Responses

---

# 💡 Challenges Solved

During development, several real-world backend challenges were encountered and resolved, including:

- JWT Authentication Configuration
- Spring Security Setup
- Hibernate Entity Relationships
- JPA Mapping Issues
- Flyway Migration Failures
- Railway Deployment Configuration
- MySQL Integration
- Git & GitHub Version Control

These experiences provided valuable hands-on exposure to production-style backend development and debugging.

---

# 📚 Future Enhancements

- Order Management
- Payment Integration
- Email Notifications
- Docker Support
- Unit Testing
- Integration Testing
- Role-Based Authorization
- Redis Caching
- CI/CD Pipeline
- Kubernetes Deployment

---

# 👨‍💻 Author

**Syed Saqlain S**

Java Backend Developer

GitHub:
https://github.com/syedsaqlainsadic

LinkedIn:
https://www.linkedin.com/in/syed-saqlain-6719a81b6/

---

# ⭐ If you found this project interesting

Please consider giving this repository a ⭐.

Feedback, suggestions, and contributions are always welcome!
