# Blog Application


This project is developed by a team of 4 members with the help of the Spring-Boot framework.It is Back-End project build in construct week at masai.
It contained all the basic CRUD operation related to different entity.

## Contributors (Individual Project)
- [@kajol](https://github.com/Kajol1106)



## Tech Stack and Tools
- Java
- Spring Boot Framework
- Spring Data JPA
- Spring MVC
- Hibernate
- MySQL
- Swagger
- Lombok
- Postman Rest Client (API Testing)
- Maven ORM
- Apache Tomcat Server (Embedded server in SpringBoot App)
- STS


## Modules
- User Module
- Post Module
- Category Module
- Comment Module

## Features
User Features:
- user should create, update, delete and list posts
- user shoud add, update, delete comments on posts.
- new user should able to register on our application
 
Categories Features:
 - categories the posts according to categories
 
 Post Features:
 - posts API includes pagination and sorting
 
 ## Used Architecture 
 
 Layered Architecture
- Controller -> API Layere -> Service -> Business Logic -> Repositories -> DAO Layer (Data Access) 

  
## Installation & Run
- To run this API server, you should update the database configuration inside the application.properties file which is present in the src/main/resources folder.
- Update the port number, username and password as per your local database configuration.
server.port=8008
spring.datasource.url=jdbc:mysql://localhost:3306/Trim;
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=enter_username
spring.datasource.password=enter_password
```
## API Root Endpoint
```
https://localhost:8888/
```
