package com.abdul.graphqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdul.graphqldemo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
