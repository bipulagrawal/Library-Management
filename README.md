# Library-Management

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

# Library Management System
The library management system is an API based application designed using spring boot which can be used to view, return or borrow books from the library.

### Tools and Technologies
- Java 8
- Maven 3.6.3
- Spring Boot
- Java Persistent API
- H2 Database

# API Documentation
Please refer the swagger documentaion (swagger.json) for the details on the APIs created and their usage.
All the APIs can be executed using Postman.

# Pre Assumptions
- Initially the library is empty
- Any number of books can be added to the library
- Same books can be added with multiple IDs
- any number of books can be issued till the count reaches the maximum registered books

# Advantages
- Efficient way of tracking Library Books
- Easy API understanding
- Easy Book Management

# Disadvantages:
- No user login or tracking
