package com.abdul.graphqldemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdul.graphqldemo.dto.EmployeeCreateDto;
import com.abdul.graphqldemo.dto.EmployeeDto;
import com.abdul.graphqldemo.dto.EmployeeUpdateDto;
import com.abdul.graphqldemo.entity.Employee;
import com.abdul.graphqldemo.mapper.EmployeeMapper;
import com.abdul.graphqldemo.repository.EmployeeRepository;
import com.abdul.graphqldemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	 @Autowired
	 private EmployeeMapper employeeMapper;

	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Employee byId = employeeRepository.findById(id).get();
	
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public List<EmployeeDto> getAllEmployeesDto() {
        List<Employee> all = employeeRepository.findAll();
		return all.stream().map(e->employeeMapper.toDto(e)).toList();
	}

	@Override
	public EmployeeDto getEmployeeDtoById(Long id) {
		Employee byId = employeeRepository.findById(id).orElse(null);
		return employeeMapper.toDto(byId);
	}

	@Override
	public EmployeeDto createEmployee(EmployeeCreateDto employeeCreateDto) {
		// TODO Auto-generated method stub
		Employee entity = new Employee();
		entity.setName(employeeCreateDto.name());
		entity.setSalary(employeeCreateDto.salary());
		Employee save = employeeRepository.save(entity);
		return employeeMapper.toDto(save);
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeUpdateDto updateInput) {
		// TODO Auto-generated method stub
		Employee byId = employeeRepository.findById(id).orElse(null);
		if(updateInput.name()!=null) {
		byId.setName(updateInput.name());
		}
		if(updateInput.salary()!=null) {
		byId.setSalary(updateInput.salary());
		}
		Employee updatedEntity = employeeRepository.save(byId);
		return employeeMapper.toDto(updatedEntity);
	}

	@Override
	public String deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	    employeeRepository.delete(employee);
	    
	    return "Employee deleted successfully";
	}

}
