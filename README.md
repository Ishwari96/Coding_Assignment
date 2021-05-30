# Coding_Assignment
coding-dojo-spring-boot app

## Requirements

For building and running the application you need:

- [JDK 11.0](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.assignment.spring.Application` class from your IDE by configurining Junit5 test in class path.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
If you want to access the app from outside your OpenShift installation, you have to expose the coding-dojo-spring-boot :

```shell
oc expose coding-dojo-spring-boot --hostname=www.example.com
`
