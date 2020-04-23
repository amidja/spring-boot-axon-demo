# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)


### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Logback Configuration:
https://dzone.com/articles/configuring-logback-with-spring-boot

### Database Configuration:

Following properties enable h2-console [http://localhost:8080/h2-console](http://localhost:8080/h2-console) : 
* spring.h2.console.enabled=true
* spring.h2.console.path=/h2-console

Additional properties:
* spring.datasource.url=jdbc:h2:mem:mytestdb
* spring.datasource.driverClassName=org.h2.Driver
* spring.datasource.username=sa
* spring.datasource.password=
* spring.jpa.hibernate.ddl-auto=create

### Axon Framework 

* [A sample Spring Boot application using Axon](https://www.baeldung.com/axon-cqrs-event-sourcing)
* [Event Sourcing Using Axon - Part I](http://progressivecoder.com/implementing-event-sourcing-using-axon-and-spring-boot-part-1/)
* [Event Sourcing Using Axon - Part 2](http://progressivecoder.com/implementing-event-sourcing-with-axon-and-spring-boot-part-2/)
* [Event Sourcing Using Axon - Part 3](http://progressivecoder.com/implementing-event-sourcing-with-axon-and-spring-boot-part-3/)

Reference app available from : https://github.com/dashsaurabh/event-sourcing-axon-spring-boot
https://github.com/dashsaurabh/event-sourcing-axon-spring-boot/

#### Unit testing with Axon 
	https://www.novatec-gmbh.de/en/blog/testing-event-sourcing-applications/ 
#### Axon Setup 
Project located on this url https://github.com/AxonIQ/axon-schema-generator can be used to 
generate DDL scriptss for Axon Framework. 


# Demo Application

The Swagger UI is available @ [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

The Application is layered in the following way:
- Domain layer (com.example.eventsourcing.account.aggregate, com.example.eventsourcing.account.command, com.example.eventsourcing.account.event)
- Service layer (com.example.eventsourcing.account.services.*) 
    - Command Service (Using Axon's CommandGateway)
    - Query Service (Using Axon's EventStore)
- Rest API layer (com.example.eventsourcing.account.web.controller)
    - Command API Controller
    - Query API Controller	