package com.abdul.graphqldemo.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.abdul.graphqldemo.dto.DepartmentDto;
import com.abdul.graphqldemo.dto.EmployeeDto;
import com.abdul.graphqldemo.entity.Department;
import com.abdul.graphqldemo.entity.Employee;

@Mapper(componentModel = "spring")
@Service
public interface DepartmentMapper {

	   DepartmentDto toDto(Department department);

	   EmployeeDto toDto(Employee employee);
}
