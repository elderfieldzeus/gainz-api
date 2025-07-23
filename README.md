# Gainz API

**Gainz API** is a secure, extensible **Workout Tracker REST API** built using **Java 21** and **Spring Boot 3**. It enables users to register, log in, and manage their workout sessions, with JWT authentication.

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Security** with **JWT Authentication**
- **Spring Data JPA (Hibernate)**
- **Maven**
- **Lombok**
- **Dotenv** for environment variable management
- **OpenAPI/Swagger UI**
- **Databases**:
  - MySQL (Prod)

---

## 📁 Project Structure

This project follows a clean modular architecture inspired by [this article](https://malshani-wijekoon.medium.com/spring-boot-folder-structure-best-practices-18ef78a81819):

```
src
├── config          # Security, filters, CORS, JWT config
├── controller      # API endpoints
├── dto             # Data Transfer Objects
├── model           # JPA Entities
├── repository      # Data access layer (Spring Data JPA)
├── service         # Business logic
```

---


## ⚙️ Configuration

Configure environment variables using `.env` and the `spring-dotenv` dependency:

```env
JWT_SECRET=

MYSQL_URL=
MYSQL_USERNAME=
MYSQL_PASSWORD=
```

Your `application.properties` should load from these variables.

---

## ▶️ Run Locally

```bash
./mvnw spring-boot:run
```

Or with a custom profile:

```bash
./mvnw spring-boot:run -Dspring.profiles.active=dev
```

---


## 🚀 Roadmap

- [x] JWT Authentication  
- [x] User registration/login  
- [x] Workout CRUD  
- [x] PostgreSQL, MariaDB, and MySQL support  
- [x] Swagger UI integration  
- [x] CI/CD (GitHub Actions)  
- [ ] Dockerize app  
- [ ] Role-based permissions (admin/user)  
- [ ] Global error handler  

---

## 📄 License

MIT License — free to use and modify for personal or commercial use.

---

## 🤝 Contributing

⚠️ This project is no longer maintained.
