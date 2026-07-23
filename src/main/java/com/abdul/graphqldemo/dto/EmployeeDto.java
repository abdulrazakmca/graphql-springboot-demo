package com.abdul.graphqldemo.dto;

public record EmployeeDto(Long id, String name, Double salary,DepartmentDto department) {
	

}

//public record EmployeeDto(String name, Double salary) {
//}