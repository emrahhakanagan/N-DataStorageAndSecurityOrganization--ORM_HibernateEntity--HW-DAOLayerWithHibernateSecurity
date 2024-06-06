## --- NETOLOGY HOMEWORK ---
### DATA STORAGE AND SECURITY ORGANIZATION --> ORM, Hibernate, Entity Lifecycle, Embedding, Relationships


#### --> Task 1 --> DAO Layer (Data Access Object) with Hibernate

# LayerDAO with Hibernate and Security

This project demonstrates a LayerDAO implementation using Hibernate for database interactions, along with Spring Security for securing endpoints and managing user roles.

## Features

- **CRUD Operations**: Basic CRUD operations on `Person` and `Order` entities.
- **Security**: Integration of Spring Security with in-memory authentication and method-level security.
- **Role-Based Access Control**: Users with different roles (`READ`, `WRITE`, `DELETE`) have access to specific endpoints.
- **Method-Level Security**: Use of `@Secured`, `@RolesAllowed`, and `@PreAuthorize` annotations for securing methods.

## Getting Started

### Prerequisites

- Java 17
- Maven
- PostgreSQL

### Installation

1. **Clone the repository:**

   ```bash
   git clone <repository-url>
   cd <repository-directory>

2. **Configure the database:**

Update the application.properties file with your PostgreSQL database configuration.


- spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
- spring.datasource.username=your_username
- spring.datasource.password=your_password

3. **Build and run the application:**

- mvn clean install
- mvn spring-boot:run


## Usage
1. Accessing Endpoints:

The following endpoints are secured and require appropriate roles for access:

- /read - Accessible by users with ROLE_READ.
- /write - Accessible by users with ROLE_WRITE.
- /modify - Accessible by users with ROLE_WRITE or ROLE_DELETE.
- /user - Accessible by authenticated users, matching the username with Principal.

2. Login:

Access the login page at /login. Use the following credentials for testing:

- **User 1:**
  - Username: user1
  - Password: password1
  - Role: READ
- User 2:
  - Username: user2
  - Password: password2
  - Role: WRITE
- User 3:
  - Username: user3
  - Password: password3
  - Role: DELETE

## Project Structure
- Configuration: Security configuration is in SecurityConfig.
- Entities: Person, Order, and MyUser entities.
- Repositories: JPA repositories for data access.
- Services: Business logic services.
- Controllers: REST controllers for handling HTTP requests.

## Dependencies
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot Starter Security
-  Liquibase
- PostgreSQL
- Lombok