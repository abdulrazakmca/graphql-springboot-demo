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

### Filtering and Sorting Implementation test

query {
  employees(
    page: 0,
    size: 5,
    sortBy: "salary",
    direction: "DESC"
  ) {
    content {
      id
      name
      salary
    }
    totalElements
    totalPages
  }
}

### Fragment
-----------
What is a GraphQL Fragment?

"A GraphQL Fragment is a reusable set of fields that can be referenced in multiple GraphQL queries using the spread operator (...). It helps eliminate duplicate field selections and keeps queries easier to maintain."


query {
  employeeById(id: 1) {
    ...EmployeeFields

}


fragment EmployeeFields on EmployeeDto{
  id
  name
  salary
}

Use aliases along with the fragment:

if you want to use like this, then you need to go with aliases
query {
  employeeById(id: 1) {
    ...EmployeeFields
	}
  employeeById(id: 1) {
    ...EmployeeFields
	}

}
// this will cause error
{
  "errors": [
    {
      "message": "Validation error (FieldsConflict) : 'employeeById' : fields have different arguments",
      "locations": [
        {
          "line": 127,
          "column": 3
        },
        {
          "line": 130,
          "column": 4
        }
      ],
      "extensions": {
        "classification": "ValidationError"
      }
    }
  ]
}

### Aliases
query {
  employee1:employeeById(id: 1) {
    ...EmployeeFields
  }
  employee2:employeeById(id: 2) {
    ...EmployeeFields
  }
}


### Bidirectional Mapping Department <-> Employee


@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double salary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}