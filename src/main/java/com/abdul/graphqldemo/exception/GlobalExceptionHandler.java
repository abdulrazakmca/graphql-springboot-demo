package com.abdul.graphqldemo.exception;

import java.util.Map;

import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;

//To handle global excepiton use controlleradvice
//for example register not within security need to handle exception
@ControllerAdvice
public class GlobalExceptionHandler {

//    @GraphQlExceptionHandler(EmployeeNotFoundException.class)
//	public RuntimeException handleEmsApiException(EmployeeNotFoundException ex){
//		return ex;
//		
//	}
    
    @GraphQlExceptionHandler(EmployeeNotFoundException.class)
    public GraphQLError handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return GraphqlErrorBuilder.newError()
                .errorType(ErrorType.DataFetchingException)
                .message(ex.getMessage())
                .extensions(
                        Map.of(
                                "errorCode", "EMPLOYEE_NOT_FOUND",
                                "status", 404
                        )
                )
                .build();
    }
}
