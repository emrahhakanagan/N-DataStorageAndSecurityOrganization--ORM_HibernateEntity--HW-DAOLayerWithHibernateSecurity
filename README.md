## --- NETOLOGY HOMEWORK ---
### DATA STORAGE AND SECURITY ORGANIZATION --> ORM, Hibernate, Entity Lifecycle, Embedding, Relationships


#### --> Task 1 --> DAO Layer (Data Access Object) with Hibernate

# DAO Layer with Hibernate

This project demonstrates the implementation of a DAO layer using Hibernate with Spring Boot. It includes an example of a `Person` entity and an `Order` entity with a one-to-many relationship. The project also features a controller to fetch persons based on their city of living.

## Project Structure

- **Entity Classes**:
  - `Person`: Represents a person with fields such as name, surname, age, phone number, and city of living.
  - `Order`: Represents an order with fields such as date, amount, and payment type. Each order is associated with a person.

- **Repository**:
  - `PersonDAO`: Interface defining the method to fetch persons by city.
  - `PersonDAOImpl`: Implementation of the `PersonDAO` interface using Hibernate's `EntityManager`.

- **Service**:
  - `PersonService`: Service layer to handle business logic and interact with the `PersonDAO`.

- **Controller**:
  - `PersonController`: REST controller to handle HTTP requests and return responses.

## Dependencies

The project uses the following dependencies:
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Hibernate
- Lombok

## Getting Started

### Prerequisites

Ensure you have the following installed:
- Java 17
- Maven
- PostgreSQL

### Setting Up the Database

1. Create a PostgreSQL database named `orm_hibernate_hw`.
2. Update the `application.properties` file with your database credentials.

### Running the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using Maven:
```
   mvn spring-boot:run
```

## API Endpoints
### Fetch Persons by City
* URL: /persons/by-city
* Method: GET
* Query Parameters:
  * city: The city of living of the persons to be fetched.
* Response: A list of persons living in the specified city, along with their associated orders.

## Example:
```
curl -X GET "http://localhost:8080/persons/by-city?city=city_name"
```

