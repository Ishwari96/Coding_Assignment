# Coding_Assignment
coding-dojo-spring-boot app

## Solution

API key is generated from https://openweathermap.org/appid

1.	Create a user for the postgresql app
2.	Set a password for that user
3.	Create a database weather for the app
4.	Grant privileges on the database for the user
5.	Add api key in yml for appid

Added above details in Application.yml

## Requirements

For building and running the application you need:

- [JDK 11.0](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org)
- [Postgresql](https://www.postgresql.org/download/windows/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.assignment.spring.Application` class from your IDE by configuring Junit5 test in class path.

1.	Download/Clone the project on to your local machine and follow solution steps
2.	Run the project on your machine
3.	Send a GET request in postman or open browser using http://localhost:8081/api/weather?city="AnyCity"
4.  Open Postgres and confirm if weather table is created and data saved


Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
If you want to access the app from outside your OpenShift installation, you have to expose the coding-dojo-spring-boot :

```shell
oc expose coding-dojo-spring-boot --hostname=www.example.com

