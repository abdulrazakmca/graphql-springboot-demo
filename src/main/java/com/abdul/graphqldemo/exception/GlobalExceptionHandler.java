package com.abdul.graphqldemo.exception;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

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
    
//    @GraphQlExceptionHandler(ConstraintViolationException.class)
//    public GraphQLError handleConstraintViolation(ConstraintViolationException ex) {
//
//    	Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
//    	
//    	List<?> list = constraintViolations.stream().map(violation->GraphQLError.newError().message(violation.getMessage())).toList();
//    	
//        return GraphqlErrorBuilder.newError()
//                .message(ex.getConstraintViolations()
//                        .stream()
//                        .findFirst()
//                        .map(v -> v.getMessage())
//                        .orElse("Validation failed"))
//                .build();
//    }
//    

    @GraphQlExceptionHandler(ConstraintViolationException.class)
    public List<GraphQLError> handleConstraintViolation(ConstraintViolationException ex) {

        return ex.getConstraintViolations()
                .stream()
                .map(violation ->
                        GraphqlErrorBuilder.newError()
                                .message(violation.getMessage())
                                .build())
                .toList();
    }
}
