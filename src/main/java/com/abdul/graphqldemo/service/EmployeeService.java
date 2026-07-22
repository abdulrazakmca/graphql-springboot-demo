package com.abdul.graphqldemo.service;

import java.util.List;

import com.abdul.graphqldemo.dto.EmployeeCreateDto;
import com.abdul.graphqldemo.dto.EmployeeDto;
import com.abdul.graphqldemo.dto.EmployeeUpdateDto;
import com.abdul.graphqldemo.entity.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployeesDto();

    EmployeeDto getEmployeeDtoById(Long id);
    
    EmployeeDto createEmployee(EmployeeCreateDto employeeDto);
    
    EmployeeDto updateEmployee(Long id, EmployeeUpdateDto input);
    
    String deleteEmployee(Long id);
}