
---

# E-commerce Application with Spring Boot

This Spring Boot application allows users to purchase products from an online store, ensuring secure inventory management even in concurrency scenarios.

## Technologies Used

- [Spring Boot](https://spring.io/projects/spring-boot): Java application development framework.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa): Facilitates access to relational data through the Java Persistence API (JPA) technology.
- [H2 Database](https://www.h2database.com/html/main.html): In-memory database for development and testing purposes.
- [Docker](https://www.docker.com/): Container platform for packaging, distributing, and running applications.
- [JUnit](https://junit.org/junit5/): Testing framework for Java.
- [Mockito](https://site.mockito.org/): Testing framework for simulating object behavior in a controlled environment.

## Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) 8 or higher.
- [Docker](https://www.docker.com/get-started) installed on your machine.

## Setting Up Development Environment

1. **Clone the repository**:

    ```bash
    git clone https://github.com/your-username/your-repository.git
    ```

2. **Import the project** into your preferred IDE as an existing Maven project.

3. **Start the application** from your IDE or using Maven:

    ```bash
    mvn spring-boot:run
    ```

4. **Access the application** in your web browser:

   [http://localhost:8080](http://localhost:8080)

## Running with Docker

1. **Build the application** with Maven:

    ```bash
    mvn clean package
    ```

2. **Build the Docker image**:

    ```bash
    docker build -t ecommerce-app .
    ```

3. **Run the Docker container**:

    ```bash
    docker run -p 8080:8080 ecommerce-app
    ```

4. **Access the application** in your web browser:

   [http://localhost:8080](http://localhost:8080)

## Contributing

If you'd like to contribute to this project, please:

1. Fork the repository.
2. Create a branch for your new feature (`git checkout -b feature/new-feature`).
3. Make your changes and commit (`git commit -am 'Add a new feature'`).
4. Push the branch (`git push origin feature/new-feature`).
5. Create a new pull request.

## Testing

The project includes unit and integration tests to ensure code quality. To run the tests, use the following Maven command:

```bash
mvn test
```

## Bibliography and Useful Links
Here you will find a useful resource that was used as a reference during the development of this project:

Baeldung - Understanding JPA Transaction Locks: This article on Baeldung provides valuable insights into Java Persistence API (JPA) transaction locks and their usage.
Understanding JPA Transaction Locks
Feel free to explore this resource to enhance your understanding of JPA transaction locks and their application within your Spring Boot project!

## License

This project is licensed under the [MIT License](LICENSE).

---