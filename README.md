# URLCorto

URLCorto is a backend application for shortening URLs and QR code generation.

## Description

This application allows users to shorten long URLs into more manageable ones, or create QRCode to share long URLs.

## Technologies and Dependencies

- Java 17
- Spring Boot 3.2.2
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot Starter Validation
- Google Guava 33.0.0-jre
- Google ZXing Core 3.5.2
- Google ZXing Javase 3.5.2
- Springdoc OpenAPI Starter WebMVC UI 2.3.0
- PostgreSQL (runtime)
- Project Lombok (optional)

## Building the Project

To build the project, ensure that Maven is installed on your system. Then navigate to the project directory and run the following command:

```
mvn clean install
```

## Connecting to the Database

This project uses PostgreSQL as the database. Database name, username and password should be added in `.env` file.

## Running the Application
To run the application, navigate to the project directory and run the following command:

```
mvn spring-boot:run
```
The application should start and be available at http://localhost:8080.

## Swagger

You can access the API documentation at http://localhost:8080/swagger-ui/index.html