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

2. **Execute TaskManagerApplication.java**


### 🔧 Postman Collection

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/817223-6516913f-4e61-4351-aebe-2400cd2f4f68?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D817223-6516913f-4e61-4351-aebe-2400cd2f4f68%26entityType%3Dcollection%26workspaceId%3D4fa4d780-b705-4c46-98e2-6c1b020caf26#?env%5Blocal%5D=W3sia2V5IjoidG9rZW4iLCJ2YWx1ZSI6IiIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKemRXSWlPaUpzWlhObGJtVmpZV3hxUUdkdFlXbHNMbU52YlNJc0ltbGhkQ0k2TVRjME9ESTROVFV3TWl3aVpYaHdJam94TnpRNE16Y3hPVEF5ZlEuQ1U3bG14dWI1eXhDek9uZU5SMmtvNGlQOVdyQVEuLi4iLCJjb21wbGV0ZVNlc3Npb25WYWx1ZSI6ImV5SmhiR2NpT2lKSVV6STFOaUo5LmV5SnpkV0lpT2lKc1pYTmxibVZqWVd4cVFHZHRZV2xzTG1OdmJTSXNJbWxoZENJNk1UYzBPREk0TlRVd01pd2laWGh3SWpveE56UTRNemN4T1RBeWZRLkNVN2xteHViNXl4Q3pPbmVOUjJrbzRpUDlXckFRSGtHdWw5YzZUWnktNEUiLCJzZXNzaW9uSW5kZXgiOjB9LHsia2V5IjoiYmFzZV91cmwiLCJ2YWx1ZSI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwIiwiY29tcGxldGVTZXNzaW9uVmFsdWUiOiJodHRwOi8vbG9jYWxob3N0OjgwODAiLCJzZXNzaW9uSW5kZXgiOjF9XQ==)