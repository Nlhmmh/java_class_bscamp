package com.springAPI.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.company.entity.Employee;
import com.springAPI.company.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
	private EmployeeService employeeService;
	
	// find All Employee
	@RequestMapping("/employees")
	private ResponseEntity<?> employeeList() {
		List<Employee> employeeList = employeeService.findAll();
		return ResponseEntity.ok(employeeList);
	}
	
	// find one employee
	@RequestMapping("/employee/{id}")
	private ResponseEntity<?> findEmployee(@PathVariable("id") Long id) {
		Employee employee = employeeService.findOne(id);
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}

	// Add Employee
	@PostMapping("/employees")
	private ResponseEntity<?> postEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.save(employee);
		return ResponseEntity.ok(newEmployee);
	}
	
	// Update Employee
	@PutMapping("/employees")
	private ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		Employee findEmployee = employeeService.findOne(employee.getId());
		if (findEmployee == null) {
			return ResponseEntity.notFound().build();
		}
		Employee updatedEmployee = employeeService.save(employee);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// Delete Employee
	@DeleteMapping("/employee/{id}")
	private ResponseEntity<?> removeEmployee(@PathVariable("id") Long id) {
		Employee employee = employeeService.findOne(id);
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}
		
		employeeService.removeOne(id);
		return ResponseEntity.ok().build();
	}
	
	// Employee Pagination
	@GetMapping("/employees/findByPage")
	private Page<Employee> pagination(@RequestParam("noPage") int noPage,@RequestParam("count") int count) {
		Pageable pageable = PageRequest.of(noPage, count);
		return employeeService.findByPage(pageable);
	}
	
	// SearchByFirstName
	@GetMapping("/employees/searchByFirstName")
	private List<Employee> searchEmployeeByFirstName(@RequestParam("firstName") String firstName) {
		return employeeService.searchByFirstName(firstName);
	}
	
}
