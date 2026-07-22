# graphql-springboot-demo
A production-ready GraphQL application built with Spring Boot, Spring GraphQL, Spring Data JPA, MySQL, and Maven. This project demonstrates GraphQL queries, mutations, relationships, validation, exception handling, and best practices.

### Create Database

CREATE DATABASE graphql_demo;

### Create Table

CREATE TABLE employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    salary DOUBLE
);

### Insert Records

INSERT INTO employee(name,salary)
VALUES
('Abdul',85000),
('Razak',90000),
('Tanvi',75000),
('Nihaan',95000),
('Reezu',15000);


### Get Employee By ID
  query {
   employeeById(id: 1) {
     id
     name
   }
 }

### Get All Employee
 query {
   employees {
         id
         name
     }
 }

### Create Employee
 mutation {
   createEmployee(
     input: {
       name: "test"
       salary: 75000
     }
   ) {
     id
     name
     salary
   }
 }

### Update Employee
mutation {
  updateEmployee(
    id: 1
    input: {
      name: "Abdul Razak"
      salary: 35000
    }
  ) {
    id
    name
    salary
  }
}

### Delete Employee

mutation {
  deleteEmployee(id: 6)
}

### Exception Handling, give invalid Id

mutation {
  deleteEmployee(id: 10000)
}

### Constraint Violation/ Validation of Input fields

mutation {
  createEmployee(
    input: {
      name: ""
      salary: -1
    }
  ) {
    id
    name
    salary
  }
}