# 🗂️ Task Manager

**Task Manager** is a backend application built with Spring Boot that provides a RESTful API for managing tasks. It supports creating, updating, retrieving, and deleting tasks, and is designed with modularity and maintainability in mind.

---

## 🚀 Features

- 📋 CRUD operations on tasks
- ✅ Task completion status
- 🧱 Modular architecture with service and repository layers

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3.2.2**
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL**

---

## 📦 Installation & Running Locally

### 🔧 Prerequisites

- Java 21
- Maven 3.8+
- PostgreSQL

### Create PostgreSQL user
- connect to PostgreSQL through your terminal `psql postgres`
- create your user : `CREATE ROLE your_username WITH LOGIN PASSWORD 'your_password'`;
- update `application.properties` with your credentials.

### 🏁 Running the App

1. **Clone the repository**

   ```bash
   git clone https://github.com/lesenecalj/task_manager.git
   cd task_manager