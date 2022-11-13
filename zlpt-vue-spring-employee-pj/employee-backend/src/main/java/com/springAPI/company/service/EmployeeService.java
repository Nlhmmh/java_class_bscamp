package com.springAPI.company.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springAPI.company.entity.Employee;

public interface EmployeeService {
	
	Employee save(Employee employee);
	
	List<Employee> findAll();
	
	Employee findOne(Long id);
	
	boolean removeOne(Long id);
	
	Page<Employee> findByPage(Pageable pageable);
	
	List<Employee> searchByFirstName(String firstName);

}
