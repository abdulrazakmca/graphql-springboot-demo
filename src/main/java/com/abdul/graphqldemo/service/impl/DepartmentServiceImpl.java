package com.abdul.graphqldemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdul.graphqldemo.dto.DepartmentDto;
import com.abdul.graphqldemo.entity.Department;
import com.abdul.graphqldemo.exception.ResourceNotFoundException;
import com.abdul.graphqldemo.mapper.DepartmentMapper;
import com.abdul.graphqldemo.repository.DepartmentRepository;
import com.abdul.graphqldemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private DepartmentMapper mapper;

	@Override
	public DepartmentDto getDepartmentDto(Long id) {
		Department department  = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department not found with Id :"+id));
		return mapper.toDto(department);
	}

}
