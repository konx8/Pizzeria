# Pizzeria

## General info
The main assumption of the project was to create a pizzeria with basic functions, including:
* additional user without creating an account, 
* choice of any dish, 
* possibility of choosing a dish n times,
* total cost in real time,
* sending an e-mail with the order,
* order history.

## Technologies

* Java 16
* Spring boot 2.5.3
* HMTL 5
* Thymeleaf

## Setup

The application can be launched with Maven from CMD using a command:
``mvn spring-boot:run``.
To run the application, please provide the following URL:
http://localhost:8080/home.
Access to the h2 database is available at
http://localhost:8080/h2-console.
Enter the following address in the JDBC URL field:
jdbc:h2:mem:testdb

## Examples

Sample data can be found in the data To H2.sql file. 
They should be entered into the H2 base.
