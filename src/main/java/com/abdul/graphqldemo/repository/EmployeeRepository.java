package com.abdul.graphqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdul.graphqldemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
