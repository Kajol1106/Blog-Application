# Blog Application


This project is developed by individual with the help of the Spring-Boot framework.It is Back-End project build in 4 working days.
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

## ER Diagram
![img](https://github.com/Kajol1106/Blog-Application/blob/main/BlogApplicationAPI/src/main/resources/templates/blogapperdiagram.png)

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
 
 ## Architecture 
 
 Layered Architecture
- Structure (Controller -> API Layere -> Service -> Business Logic -> Repositories -> DAO Layer (Data Access))
![img](https://github.com/Kajol1106/Blog-Application/blob/main/BlogApplicationAPI/src/main/resources/templates/layered%20Architecture.png)

User interaction layer:
- This is the layer that interacts with users through screens, forms, menus, reports, etc.
- It defines how the application looks.  

Functionality layer: 
- This is the layer that presents the functions, methods, and procedures of the system based on the business rules layer

Business rules layer:
- This layer contains rules that determine the behavior of the whole application, such as, “If an invoice is printed, then send an email to the customer, select all items sold, and decrease their stock in the stock management module.” 

Application core layer:
- This server contains the main programs, code definitions, and basic functions of the application.
- Programmers work in this layer most of the time.

Database layer:
- This layer contains the tables, indexes, and data managed by the application.
- Searches and insert/delete/update operations are executed here. 

## 👉 [Click here](https://drive.google.com/file/d/1MVQJOzg1e8fEZ4Pb0rEgS8Rf3GRf17l-/view?usp=sharing) to go through detail explanation of this application 

## 👉 [Click here](http://localhost:8888/swagger-ui/index.html#/) to go through documentation after running application in your system

  
## Installation & Run
- To run this API server, you should update the database configuration inside the application.properties file which is present in the src/main/resources folder.
- Update the port number, username and password as per your local database configuration.
server.port=8888
spring.datasource.url=jdbc:mysql://localhost:3306/Blogapp;
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=enter_username
spring.datasource.password=enter_password
```
## API Root Endpoint
```
https://localhost:8888/
```

## 

