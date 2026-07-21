package com.abdul.graphqldemo.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

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
	    
}
