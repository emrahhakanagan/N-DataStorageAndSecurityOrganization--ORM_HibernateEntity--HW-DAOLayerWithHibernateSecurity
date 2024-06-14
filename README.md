## --- NETOLOGY HOMEWORK ---
### DATA STORAGE AND SECURITY ORGANIZATION --> ORM, Hibernate, Entity Lifecycle, Embedding, Relationships


#### --> Task 1 --> DAO Layer (Data Access Object) with Hibernate

# Spring Security Method-Level Protection Example

This project demonstrates the use of method-level security in a Spring Boot application with JPA and Hibernate. The application includes role-based access control using annotations such as `@Secured`, `@RolesAllowed`, and `@PreAuthorize`.

## Project Structure

- **SecurityConfig.java**: Configuration class for setting up Spring Security.
- **PersonSecurityMethodController.java**: Controller for managing `Person` entities with method-level security.
- **SecureController.java**: Controller for demonstrating different levels of access control.
- **PersonSecurityMethodRepository.java**: Repository interface for `Person` entities.
- **PersonSecurityMethodService.java**: Service layer for `Person` entities with method-level security.
- **Person.java**: Entity class for `Person`.
- **PersonId.java**: Composite primary key class for `Person`.
- **Order.java**: Entity class for `Order`.
- **PaymentType.java**: Enum for payment types.
- **application.properties**: Configuration properties for the Spring Boot application.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL

### Setting Up the Database

1. Create a PostgreSQL database named `netology`.
2. Update the `application.properties` file with your database credentials.

### Building and Running the Application

1. Clone the repository:

    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ```

### Testing the Endpoints

Use a tool like Postman or cURL to test the different endpoints provided by the application.

#### Public Endpoints

- `GET /security/welcome`: Accessible without authentication.

#### Secured Endpoints

- `GET /security/by-city?city={city}`: Requires the `ROLE_ADMIN` authority.
- `GET /security/by-age?age={age}`: Requires the `ROLE_ADMIN` authority.
- `GET /security/by-name-surname?name={name}&surname={surname}`: Requires the `ROLE_ADMIN` authority.

### Method-Level Security Annotations

- `@Secured("ROLE_READ")`: Restricts access to users with the `ROLE_READ` authority.
- `@RolesAllowed("ROLE_WRITE")`: Restricts access to users with the `ROLE_WRITE` authority.
- `@PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")`: Restricts access to users with either the `ROLE_WRITE` or `ROLE_DELETE` authority.
- `@PreAuthorize("#username == authentication.name")`: Restricts access to the authenticated user whose username matches the `username` parameter.
