package com.abdul.graphqldemo.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.abdul.graphqldemo.dto.DepartmentDto;
import com.abdul.graphqldemo.dto.EmployeeCreateDto;
import com.abdul.graphqldemo.dto.EmployeeDto;
import com.abdul.graphqldemo.dto.EmployeeUpdateDto;
import com.abdul.graphqldemo.entity.Department;
import com.abdul.graphqldemo.entity.Employee;

@Mapper(componentModel = "spring")
@Service
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto dto);
    
    DepartmentDto toDto(Department department);
    
    Employee toEntity(EmployeeCreateDto dto);

    Employee toEntity(EmployeeUpdateDto dto);
}