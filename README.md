## --- NETOLOGY HOMEWORK ---
### DATA STORAGE AND SECURITY ORGANIZATION --> ORM, Hibernate, Entity Lifecycle, Embedding, Relationships


#### --> Task 1 --> DAO Layer (Data Access Object) with Hibernate

# DAO Layer with Hibernate

## Description

This project is a Spring Boot application that demonstrates the use of the Data Access Object (DAO) pattern with Hibernate. It includes functionalities to interact with a database of persons, specifically allowing retrieval of persons based on their city of living.

## Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- PostgreSQL or another relational database

## Getting Started

### Clone the Repository

```
git clone <repository-url>
cd <repository-directory>
```

## Set Up the Database
Create a PostgreSQL database named.
Update the application.properties file with your PostgreSQL username and password.

## Build and Run the Application
- mvn clean install
- mvn spring-boot:run


## Application Structure
- Entity: The Person entity represents the persons table in the database.
- DAO: The PersonDAOImpl class provides methods to interact with the database.
- Service: The PersonService class contains business logic and calls the DAO methods.
- Controller: The PersonController class handles HTTP requests and responses.

## API Endpoints
- GET /persons/by-city: Retrieves a list of persons based on the city of living.
  - Query Parameters:
      - city (String): The name of the city.

## Example Request
curl -X GET "http://localhost:8080/persons/by-city?city=Moscow"

## Dependencies
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- PostgreSQL JDBC Driver
- Lombok