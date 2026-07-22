package com.abdul.graphqldemo.controller;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.abdul.graphqldemo.model.Employee;

@Controller
public class HelloController {

//	  @QueryMapping
//	  public String hello() {
//	        return "Hello GraphQL";
//	    }
//	  
	@QueryMapping
	public String hello(@Argument String name) {

		if (name == null || name.isBlank()) {
			return "Hello Guest";
		}

		return "Hello " + name;
	}

	@QueryMapping
	public Employee helloEmployee() {
		return new Employee(1L, "Abdul", 10000.50);
	}
	
	@QueryMapping
	public List<Employee> helloEmployees(){
		return getEmployees();
	}
	
	@QueryMapping
	public Employee helloEmployeeById(@Argument Long id) {
	   return getEmployees().stream()
				            .filter(byId(id))
				            .findFirst()
				            .orElse(null);
	}
	
	private List<Employee> getEmployees(){
		Employee e1 = new Employee(1L, "Abdul", 10000.50);
		Employee e2 = new Employee(2L, "Razak", 20000.50);
		return List.of(e1,e2);
	}
	
	private static Predicate<Employee> byId(Long id){
		
		return emp -> emp.getId().equals(id);
	}
}
