# Fitness Tracker Backend API

A production-ready Fitness Tracker Backend built using Spring Boot, Spring Security, JWT Authentication, MySQL, Swagger, and Docker.

This project allows users to:
- Register & Login securely
- Track fitness activities
- Manage workouts
- Access protected APIs using JWT tokens
- Perform admin operations with role-based authorization

---

# Features

## Authentication & Security

- JWT Authentication
- Spring Security Integration
- Password Encryption using BCrypt
- Role-Based Authorization (USER / ADMIN)
- Stateless Session Management

## Activity Management

- Track activities
- Update activities
- Delete activities
- Fetch user activities

## Admin Features

- View all registered users
- Protected admin APIs

## API Documentation

- Swagger UI Integration
- Interactive API Testing

## DevOps

- Docker Support
- Docker Compose Support
- GitHub Version Control

---

# Tech Stack

| Technology | Used |
|---|---|
| Java 17 | Backend Language |
| Spring Boot | Framework |
| Spring Security | Authentication |
| JWT | Token Authentication |
| Hibernate/JPA | ORM |
| MySQL | Database |
| Maven | Build Tool |
| Swagger/OpenAPI | API Documentation |
| Docker | Containerization |
| Git & GitHub | Version Control |

---

# Project Structure

```bash
src/main/java/com/project/fitness
│
├── controller
├── service
├── repository
├── model
├── dto
├── security
├── exception
├── config
```

---

# API Endpoints

## Authentication APIs

### Register User

```http
POST /api/auth/register
```

### Login User

```http
POST /api/auth/login
```

---

## Activity APIs

### Create Activity

```http
POST /api/activities
```

### Get User Activities

```http
GET /api/activities
```

### Update Activity

```http
PUT /api/activities/{activityId}
```

### Delete Activity

```http
DELETE /api/activities/{activityId}
```

---

## Admin APIs

### Get All Users

```http
GET /api/admin/users
```

---

# Swagger Documentation

After running the project:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

# Run Project Locally

## Clone Repository

```bash
git clone https://github.com/pragya638/fitness-tracker-backend.git
```

## Move Into Project

```bash
cd fitness-tracker-backend
```

## Run Application

```bash
./mvnw spring-boot:run
```

---

# Docker Setup

## Build Docker Image

```bash
docker build -t fitness-app .
```

## Run Docker Container

```bash
docker run -p 8080:8080 fitness-app
```

---

# Docker Compose

Run complete backend + MySQL:

```bash
docker-compose up --build
```

---

# Database Configuration

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fitness_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

# JWT Authentication Flow

1. Register/Login User
2. Receive JWT Token
3. Add Token in Authorization Header

```http
Authorization: Bearer your_jwt_token
```

4. Access Protected APIs

---

# Future Improvements

- React Frontend
- AI Workout Recommendations
- Progress Analytics Dashboard
- Email Verification
- Refresh Tokens
- Cloud Deployment
- Unit Testing
- CI/CD Pipeline
- Mobile App Integration

---

# Author

## Pragya Dwivedi

Aspiring Java Backend Developer focused on:

- Spring Boot
- Backend Development
- REST APIs
- Security
- Deployment
- Real-world Projects

---

# GitHub Repository

🔗 https://github.com/pragya638/fitness-tracker-backend
