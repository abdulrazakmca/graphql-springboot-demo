package com.abdul.graphqldemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.abdul.graphqldemo.dto.DepartmentDto;
import com.abdul.graphqldemo.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@QueryMapping
	public DepartmentDto getDepartmentDto(@Argument Long id) {
		
		return departmentService.getDepartmentDto(id);
		
	}
}
