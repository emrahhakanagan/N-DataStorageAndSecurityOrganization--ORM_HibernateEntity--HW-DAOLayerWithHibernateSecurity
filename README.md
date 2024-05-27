## --- NETOLOGY HOMEWORK ---
### DATA STORAGE AND SECURITY ORGANIZATION --> ORM, Hibernate, Entity Lifecycle, Embedding, Relationships


#### --> Task 1 --> DAO Layer (Data Access Object) with Hibernate

# Layer DAO with JPA Repositories and JPQL Queries

## Description

This project demonstrates the use of JPA Repositories with JPQL Queries in a Spring Boot application. The application manages `Person` and `Order` entities, allowing CRUD operations and custom queries using JPQL.

## Setup and Running the Application

1. **Clone the Repository**

    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Configure Database**

   Update the `application.properties` file with your PostgreSQL database configuration.

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

3. **Run the Application**

    ```sh
    ./mvnw spring-boot:run
    ```

## Endpoints

1. **Get Persons by City**

    ```
    GET /persons/by-city?city={city}
    ```

   Returns a list of persons living in the specified city.

2. **Get Persons by Age**

    ```
    GET /persons/by-age-less-than?age={age}
    ```

   Returns a list of persons younger than the specified age, sorted by age in ascending order.

3. **Get Person by Name and Surname**

    ```
    GET /persons/by-name-surname?name={name}&surname={surname}
    ```

   Returns the person with the specified name and surname.

## Project Structure

- **PersonRepositoryJPA_QueryJPQL**: Interface for database operations using JPQL queries.
- **PersonService**: Service layer for business logic.
- **PersonController**: REST controller for handling HTTP requests.

## Dependencies

- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- PostgreSQL Driver
- Lombok

## Contributing

1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.
