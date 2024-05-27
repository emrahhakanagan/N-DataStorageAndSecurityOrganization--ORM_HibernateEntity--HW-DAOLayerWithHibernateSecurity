## --- NETOLOGY HOMEWORK ---
### DATA STORAGE AND SECURITY ORGANIZATION --> ORM, Hibernate, Entity Lifecycle, Embedding, Relationships


#### --> Task 1 --> DAO Layer (Data Access Object) with Hibernate

# Hibernate DAO Layer with Liquibase Migration

# LayerDAO with Hibernate

This project demonstrates the implementation of a Data Access Layer using Hibernate and JPA Repositories with Spring Boot. The project includes basic CRUD operations and custom queries for a `Person` entity and an `Order` entity.

## Technologies Used

- Java 17
- Spring Boot 3.2.5
- Hibernate
- Spring Data JPA
- PostgreSQL
- Liquibase

## Getting Started

### Prerequisites

- Java 17
- Maven
- PostgreSQL

### Installation

1. Clone the repository:

```
   git clone <repository-url>
```

2. Navigate to the project directory:
```
cd LayerDAO_Hibernate
```

3. Update the PostgreSQL credentials in the application.properties file:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. Run the application:
```
mvn spring-boot:run
```

## API Endpoints

### Get Persons by City
* URL: /persons/by-city
* Method: GET
* Query Params: city
* Description: Retrieves a list of persons living in the specified city.
* Example:
```
curl -X GET "http://localhost:8080/persons/by-city?city=Moscow"
```

### Get Persons by Age Less Than
* URL: /persons/by-age
* Method: GET
* Query Params: age
* Description: Retrieves a list of persons younger than the specified age, sorted by age in ascending order.
* Example:
```
curl -X GET "http://localhost:8080/persons/by-age?age=30"
```

### Get Person by Name and Surname
* URL: /persons/by-name-surname
* Method: GET
* Query Params: name, surname
* Description: Retrieves a person by their name and surname.
* Example:
```
curl -X GET "http://localhost:8080/persons/by-name-surname?name=John&surname=Doe"
```

Database Schema
The schema is managed using Liquibase and can be found in the db.changelog-master.yaml file.

## Contributing
1. Fork the repository.
2. Create a new branch.
3. Make your changes and commit them.
4. Push to your branch.
5. Create a pull request.
