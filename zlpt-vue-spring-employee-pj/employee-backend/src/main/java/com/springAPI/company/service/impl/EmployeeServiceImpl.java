package com.springAPI.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springAPI.company.entity.Employee;
import com.springAPI.company.repository.EmployeeRepo;
import com.springAPI.company.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepo.findAll();
	}

	@Override
	public Employee findOne(Long id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id).orElse(null);
	}

	@Override
	public boolean removeOne(Long id) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(id);
		return true;
	}

	@Override
	public Page<Employee> findByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepo.findAllByOrderByGenderDescFirstNameAsc(pageable);
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return employeeRepo.searchByFirstName("%" + firstName + "%");
	}

	
	

}
