package com.abdul.graphqldemo.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.abdul.graphqldemo.dto.EmployeeDto;
import com.abdul.graphqldemo.entity.Employee;

@Mapper(componentModel = "spring")
@Service
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto dto);
}