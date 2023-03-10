# Blog Application


This project is developed by individual with the help of the Spring-Boot framework.It is Back-End project build in construct week at masai.
It contained all the basic CRUD operation related to different entity.

## Contributors (Individual Project)
- [@kajol](https://github.com/Kajol1106)


## Tech Stack and Tools
- Java
- Spring Boot Framework
- Spring Data JPA
- Hibernate
- MySQL
- Swagger
- Lombok
- Postman Rest Client (API Testing)
- Maven ORM
- Apache Tomcat Server (Embedded server in SpringBoot App)
- STS
- Git & Github


## Modules
- User Module
- Post Module
- Category Module
- Comment Module

## Features
User Features:
- user should create, update, delete and list posts
- new user should able to register on our application
 
Categories Features:
 - categories the posts according to categories
 - user can fetch one specific category or list of categories.
 - user can delete and update the category.
 
 Post Features:
 - user can fetch posts using user Id or category Id or post Id
 - user can fetch all posts
 - user can delete and update the post
 - posts API includes pagination and sorting
 - you can search posts using keyword.
 - posts include one image too.
 - user can get the specific image also.
 
 Comment Features:
 - user shoud add, update, delete comments on posts.
 
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
