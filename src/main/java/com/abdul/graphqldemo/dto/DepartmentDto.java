package com.abdul.graphqldemo.dto;

import java.util.List;

public record DepartmentDto(Long id, String name,List<EmployeeSummaryDto> employees) {
	

}