package com.springAPI.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springAPI.company.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
