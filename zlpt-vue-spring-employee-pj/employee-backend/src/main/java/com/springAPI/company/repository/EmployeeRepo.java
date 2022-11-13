package com.springAPI.company.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springAPI.company.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	Page<Employee> findAll(Pageable pageable);
	
	@Query(value = "SELECT * FROM employee WHERE first_name LIKE ?1", nativeQuery = true)
	List<Employee> searchByFirstName(String firstName);
	
	Page<Employee> findAllByOrderByGenderDescFirstNameAsc(Pageable pagable);
}
