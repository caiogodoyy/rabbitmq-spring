# RabbitMQ with Spring Boot Demo

This project is a simple demonstration of integrating RabbitMQ with a Spring Boot application. RabbitMQ is a powerful message broker that allows for efficient communication between different parts of a system. In this demo, we'll showcase how to set up a basic Spring Boot application that produces and consumes messages using RabbitMQ.

## Prerequisites

Make sure you have the following installed:

- Java 17
- Maven
- RabbitMQ Server (you can run it in a Docker container using the following command)
```bash
docker run --name rabbitmq -p 15672:15672 -p 5672:5672 -d rabbitmq:3.10.5-management
```

## Getting Started

1. Clone this repository:

    ```bash
    git clone https://github.com/yourusername/rabbitmq-spring-boot-demo.git
    ```

2. Navigate to the project directory:

    ```bash
    cd rabbitmq-spring-boot-demo
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

This will start the Spring Boot application, and it will automatically connect to the RabbitMQ server.

## Producing Messages

To produce messages, you can go to http://localhost:8080/send?message=`your_message`&routingkey=`your_routingkey`

## Consuming Messages

The application has a simple message consumer that listens for messages. When a message is received, it will be printed to the console.
