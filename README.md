# User & Email Microservices

This repository contains a microservices-based application designed to manage users and send emails asynchronously. It is built using **Java 21**, **Spring Boot 3**, and follows **Clean Architecture** principles.

> **Note:** This project was created as a foundational study of microservices architecture and event-driven communication using RabbitMQ. The primary goal was to understand the structure, decoupling, and interaction between services in a distributed system.

The system consists of two main services:
1.  **User Service**: Manages user registration and listing. Publishes events to RabbitMQ upon user creation.
2.  **Email Service**: Consumes events from RabbitMQ and sends welcome emails using SMTP (Gmail).

---

## Technologies

*   **Java 21**
*   **Spring Boot 3.5.9**
*   **Spring Data JPA** (PostgreSQL)
*   **Spring AMQP** (RabbitMQ)
*   **Flyway** (Database Migrations)
*   **SpringDoc OpenAPI** (Swagger UI)
*   **JavaMailSender** (SMTP)
*   **Docker & Docker Compose**
*   **Lombok**

---

## Architecture

The project follows **Clean Architecture** to ensure separation of concerns, testability, and maintainability.

### Layers:
*   **Core**: Contains the business logic (Use Cases), Domain Entities, and Interfaces (Gateways). This layer is independent of frameworks.
*   **Infrastructure**: Contains the implementation of Gateways, Controllers, Persistence (Repositories), Configuration, and external integrations (RabbitMQ, SMTP).

---

## Services Overview

### 1. User Service (`user-service`)
*   **Port**: `8081`
*   **Database**: PostgreSQL (`ms-user-ms`)
*   **Responsibilities**:
    *   Create new users.
    *   List all registered users.
    *   Publish `UserCreated` events to RabbitMQ.
*   **Documentation**: Swagger UI available at `http://localhost:8081/swagger-ui.html`

### 2. Email Service (`email-service`)
*   **Port**: `8080`
*   **Database**: PostgreSQL (`ms-email-ms`)
*   **Responsibilities**:
    *   Listen to `email-queue` on RabbitMQ.
    *   Send emails using Google SMTP.
    *   Store email logs (status, content, timestamp) in the database.

---

## Future Improvements

As this is a foundational project, there are several features that could be implemented to make it production-ready:

*   **Authentication & Authorization**: Implement **Spring Security** with **JWT (JSON Web Tokens)** to secure the API endpoints.
*   **API Gateway**: Introduce an API Gateway (e.g., Spring Cloud Gateway) to route requests and handle cross-cutting concerns like rate limiting.
*   **More Events**: Add events for other user actions (e.g., `UserUpdated`, `PasswordReset`) to trigger different email types.

---

## Setup & Installation

### Prerequisites
*   Java 21 SDK
*   Maven
*   Docker & Docker Compose

### Environment Variables
You need to set the following environment variables for the services to work (or configure them in your IDE/Docker).

**RabbitMQ (CloudAMQP)**
This project uses CloudAMQP for message queuing. You need to create an instance and get the credentials.
*   `RABBITMQ_HOST`: Your CloudAMQP host.
*   `RABBITMQ_USER`: Your CloudAMQP user.
*   `RABBITMQ_PASS`: Your CloudAMQP password.
*   `RABBITMQ_VHOST`: Your CloudAMQP vhost.

**Email Service (SMTP)**
*   `EMAIL_USER`: Your Gmail address.
*   `EMAIL_PASSWORD`: Your Gmail App Password (not your regular password).

### Running with Docker Compose
The project includes a `docker-compose.yaml` file to spin up the **PostgreSQL databases**.

1.  **Start Databases**:
    ```bash
    docker-compose up -d
    ```
    *This will start PostgreSQL containers for both services.*

2.  **Run Applications**:
    You can run the applications using your IDE or Maven:
    ```bash
    # User Service
    cd user-service
    ./mvnw spring-boot:run

    # Email Service
    cd email-service
    ./mvnw spring-boot:run
    ```

---

## API Endpoints (User Service)

### Create User
*   **URL**: `/api/v1/user-ms/create`
*   **Method**: `POST`
*   **Body**:
    ```json
    {
      "name": "Flamengo",
      "email": "flamengo@example.com"
    }
    ```

### List Users
*   **URL**: `/api/v1/user-ms/list`
*   **Method**: `GET`

---

## Database Migrations
This project uses **Flyway** to manage database schemas.
*   Migrations are located in `src/main/resources/db/migration`.
*   They are automatically applied when the application starts.

---

## License
This project is licensed under the MIT License.
