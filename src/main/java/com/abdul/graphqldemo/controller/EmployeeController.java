package com.abdul.graphqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.abdul.graphqldemo.dto.EmployeeCreateDto;
import com.abdul.graphqldemo.dto.EmployeeDto;
import com.abdul.graphqldemo.dto.EmployeePageDto;
import com.abdul.graphqldemo.dto.EmployeeUpdateDto;
import com.abdul.graphqldemo.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @QueryMapping
//    public List<EmployeeDto> employees() {
//        return employeeService.getAllEmployeesDto();
//    }

    @QueryMapping
    public EmployeePageDto employees(
            @Argument int page,
            @Argument int size,
            @Argument String sortBy,
            @Argument String direction) {

        return employeeService.getEmployees(
                page,
                size,
                sortBy,
                direction);
    }
    
    @QueryMapping
    public EmployeeDto employeeById(@Argument Long id) {
        return employeeService.getEmployeeDtoById(id);
    }
    
    @MutationMapping
    public EmployeeDto createEmployee(@Argument("input") @Valid EmployeeCreateDto employeeDto) {
    	return employeeService.createEmployee(employeeDto);
    }

    @MutationMapping
    public EmployeeDto updateEmployee(@Argument Long id,@Argument("input") @Valid EmployeeUpdateDto employeeDto) {
    	return employeeService.updateEmployee(id, employeeDto);
    }
    
    @MutationMapping
    public String deleteEmployee(@Argument Long id) {
    	return employeeService.deleteEmployee(id);
    }

}