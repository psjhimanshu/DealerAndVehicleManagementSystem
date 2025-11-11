# Dealer & Vehicle Management API with Payment Simulation

##  Overview
This project is a **Spring Boot RESTful API** for managing **Dealers**, their **Vehicles**, and simulating **Payment processing** for dealer subscriptions.  
It uses **Spring Boot**, **Spring Data JPA**, and **MySQL** for persistence, along with clean exception handling and a simulated asynchronous payment callback system.

---

##  Features

###  Dealer Management
- Create, Read, Update, and Delete (CRUD) dealers  
- Fields: `id`, `name`, `email`, `subscriptionType` (BASIC / PREMIUM)

###  Vehicle Management
- CRUD operations for vehicles  
- Fields: `id`, `dealerId`, `model`, `price`, `status` (AVAILABLE / SOLD)
- Fetch all vehicles that belong **only to PREMIUM dealers**

###  Payment Gateway Simulation
- Endpoint: `/api/payment/initiate`
- Accepts: `dealerId`, `amount`, `method` (UPI / Card / NetBanking)
- Saves payment as `PENDING`, then automatically updates to `SUCCESS` after 5 seconds (simulating real-world payment callback)

### ⚙️ Exception Handling
- Centralized error handling using `@ControllerAdvice`
- Custom exceptions such as `ResourceNotFoundException`
- Returns clean, user-friendly JSON error messages

---

##  Tech Stack

| Technology | Purpose |
|-------------|----------|
| **Spring Boot** | Backend framework |
| **Spring Data JPA** | ORM for database operations |
| **MySQL** | Relational database |
| **Lombok** | Reduces boilerplate code |
| **Postman** | API testing |
| **Java 17+** | Programming language |

---

##  Configuration

###  application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/dealership_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
