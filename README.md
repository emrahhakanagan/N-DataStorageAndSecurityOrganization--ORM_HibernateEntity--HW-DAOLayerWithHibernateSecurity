## --- NETOLOGY HOMEWORK ---
### DATA STORAGE AND SECURITY ORGANIZATION --> ORM, Hibernate, Entity Lifecycle, Embedding, Relationships


#### --> Task 1 --> DAO Layer (Data Access Object) with Hibernate

# Hibernate DAO Layer with Liquibase Migration

This project demonstrates the implementation of a DAO layer using Hibernate and Liquibase for database migrations in a Spring Boot application. It includes entities representing `Person` and `Order`, and demonstrates the use of one-to-many and many-to-one relationships.

## Project Structure

- `entity` package: Contains the `Person` and `Order` entity classes.
- `dao` package: Contains the DAO interfaces and implementations.
- `service` package: Contains the service classes.
- `controller` package: Contains the controller classes.
- `resources/db/changelog`: Contains Liquibase changelog files for database migrations.

## Setup and Run

1. **Clone the Repository**

```
   git clone <repository-url>
   cd <repository-directory>
```

2. Create Database

Ensure you have a PostgreSQL database running and create a new database for the project.
```
CREATE DATABASE yourdatabase;
```

3. Configure Application Properties

Update the src/main/resources/application.properties file with your database credentials.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.yaml
```

4. Build and Run the Application
```
mvn clean install
mvn spring-boot:run
```

5. Access the Application
```
The application will be accessible at http://localhost:8080.
```

## API Endpoints

### Get Persons by City
```
GET /persons/by-city?city={city}
```

This endpoint retrieves a list of persons living in the specified city.

## Database Migrations
The project uses Liquibase for database migrations. 
The changelog files are located in the src/main/resources/db/changelog directory.

## Changelog Files
* db.changelog-master.yaml: The main changelog file that includes all individual changelog files.
* V0001__create_schema.sql: Creates the database schema.
* V0002__create_table_person.sql: Creates the person table.
* V0003__create_table_orders.sql: Creates the orders table.
* V0004__alter_table_orders.sql: Alter the orders table.
* V0005__insert_into_person.sql: Insert into the person table.
* V0006_insert_into_orders.sql: Insert into the orders table.

## Technologies Used
* Spring Boot
* Hibernate
* Liquibase
* PostgreSQL
* Maven