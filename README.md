## --- NETOLOGY HOMEWORK ---
### DATA STORAGE AND SECURITY ORGANIZATION --> ORM, Hibernate, Entity Lifecycle, Embedding, Relationships


#### --> Task 1 --> DAO Layer (Data Access Object) with Hibernate

# ORM Hibernate Entity Lifecycle Embedding Relationships HW - LayerDAO Hibernate with Spring Security (Security Filter Chain)

This project demonstrates using Hibernate ORM for managing entity lifecycle and embedding relationships using a Layered DAO pattern. It includes configurations for security and access control using Spring Security.

## Project Structure

### Configuration Files

- **SecurityConfig.java**: Configuration for Spring Security, defining user roles, authentication providers, and security filter chains.
- **application.properties**: Application configuration properties.
- **db.changelog-master.yaml**: Liquibase changelog file for database migrations.

### Entities

- **Person.java**: Entity representing a person.
- **PersonId.java**: Composite key class for the Person entity.
- **Order.java**: Entity representing an order.
- **MyUser.java**: Entity representing a user in the system.

### Repositories

- **PersonSecurityMethodRepository.java**: JPA repository for the Person entity.
- **MyUserDAO.java**: Data access object for the MyUser entity.
- **PersonSecurityRepository.java**: Another JPA repository for the Person entity used in a different context.

### Services

- **PersonSecurityMethodService.java**: Service layer for managing Person entities.
- **MyUserDetailsService.java**: Service for loading user-specific data.
- **PersonSecurityService.java**: Another service layer for managing Person entities with security methods.

### Controllers

- **PersonSecurityMethodController.java**: REST controller for managing Person entities.
- **SecureController.java**: REST controller for demonstrating security features.

## Endpoints

### Public Endpoints

- **GET /security-test/welcome**: Publicly accessible endpoint.

### Protected Endpoints

- **GET /security-test/test**: Requires ADMIN authority.
- **GET /security-test/write**: Requires ADMIN or WRITE authority.
- **GET /security-test/modify**: Requires WRITE or DELETE authority.
- **GET /security-test/user**: Requires authentication, returns the username of the authenticated user.

## Running the Application

1. Clone the repository.
2. Update the `application.properties` with your database configuration.
3. Run the application using the following command:
   ```sh
   mvn spring-boot:run
4. Access the application at http://localhost:8080.

## Example Requests
- Public Endpoint:
```sh
  GET http://localhost:8080/security-test/welcome
```

- Protected Endpoint (ADMIN role required):
```sh
  GET http://localhost:8080/security-test/test
```