package com.springAPI.company.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.springAPI.company.entity.Department;
import com.springAPI.company.entity.Employee;
import com.springAPI.company.entity.Gender;
import com.springAPI.company.repository.EmployeeRepo;
import com.springAPI.company.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Mock
	private EmployeeRepo employeeRepo;

	@Test
	void should_get_all_employees() {
		
		List<Employee> employeeList = new ArrayList<>();

		Employee employee1 = new Employee(1L, "Zaw", "Lay Pyay Thar", 21, Gender.MALE,
				new Department(1, "Admin", LocalDateTime.now()));
		
		Employee employee2 = new Employee(2L, "John", "Wick", 23, Gender.MALE,
				new Department(2, "Coding", LocalDateTime.now()));
		
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		when(employeeRepo.findAll()).thenReturn(employeeList);
		
		List<Employee> actualEmployee = employeeService.findAll();
		
		assertThat(actualEmployee).hasSize(2);
		assertThat(actualEmployee).contains(employee1);
		assertThat(actualEmployee).contains(employee2);
		
		verify(employeeRepo,times(1)).findAll();

	}
	
	@Test
	void should_create_and_update_one_employee() {
		
		Employee employee = new Employee(1L, "John", "Wick", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		when(employeeRepo.save(any(Employee.class))).thenReturn(employee);
		
		Employee actualEmployee = employeeService.save(employee);
		
		assertThat(actualEmployee).usingRecursiveComparison().isEqualTo(employee);
		
		verify(employeeRepo, times(1)).save(employee);
		
	}
	
	@Test
	void should_get_one_employee() {
		
		Employee employee = new Employee(1L, "John", "Wick", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		when(employeeRepo.findById(any(Long.class))).thenReturn(Optional.of(employee));
		
		Employee actualEmployee = employeeService.findOne(1L);
		
		assertThat(actualEmployee).usingRecursiveComparison().isEqualTo(employee);
		
		verify(employeeRepo, times(1)).findById(any(Long.class));
		
	}
	
	@Test
	void should_delete_one_employee() {
		
		doNothing().when(employeeRepo).deleteById(any());
		boolean actual = employeeService.removeOne(1L);
		assertThat(actual).isEqualTo(true);
		verify(employeeRepo, times(1)).deleteById(any(Long.class));
	 	
	}
	
//	@Test
//	void should_delete_one_employee() {
//		
//		Employee employee = new Employee(1L, "John", "Wick", 23, Gender.MALE,
//				new Department(1, "Coding", LocalDateTime.now()));
//		
//	        final Long id = employee.getId();
//	        employeeService.removeOne(id);
//	        Mockito.verify(employeeRepo).deleteById(id);
//	 	
//	}
	
	@Test
	void should_search_by_firstname() {
		List<Employee> employeeList = new ArrayList<>();
		
		Employee employee1 = new Employee(1L, "John", "Wick", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		Employee employee2 = new Employee(2L, "John", "Swanson", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		when(employeeRepo.searchByFirstName(any(String.class))).thenReturn(employeeList);
		
		List<Employee> actualEmployeeList = employeeService.searchByFirstName("John");
		
		assertThat(actualEmployeeList).usingRecursiveComparison().isEqualTo(employeeList);
		
		verify(employeeRepo).searchByFirstName(any(String.class));
		
	}
	
	@Test
	void should_get_pagination_employees() {
		
		List<Employee> employeeList = new ArrayList<>();
		
		Employee employee1 = new Employee(1L, "John", "Wick", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		Employee employee2 = new Employee(2L, "John", "Swanson", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		Employee employee3 = new Employee(3L, "John", "Swanson", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		Employee employee4 = new Employee(4L, "John", "Swanson", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		Employee employee5 = new Employee(5L, "John", "Swanson", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);

		Page<Employee> pageEmployee = new PageImpl<>(employeeList);
		
		Pageable pageable = PageRequest.of(0, 3);
		
		when(employeeRepo.findAllByOrderByGenderDescFirstNameAsc(any(Pageable.class))).thenReturn(pageEmployee);
		
		Page<Employee> actualEmployee = employeeService.findByPage(pageable);
		
		assertThat(actualEmployee).usingRecursiveComparison().isEqualTo(pageEmployee);
		
		verify(employeeRepo).findAllByOrderByGenderDescFirstNameAsc(pageable);
		
	}

}
