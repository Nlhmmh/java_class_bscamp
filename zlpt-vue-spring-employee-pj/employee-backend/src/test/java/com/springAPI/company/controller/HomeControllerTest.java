package com.springAPI.company.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.springAPI.company.entity.Department;
import com.springAPI.company.entity.Employee;
import com.springAPI.company.entity.Gender;
import com.springAPI.company.service.impl.EmployeeServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeServiceImpl employeeService;

	@Test
	void should_return_api_getallemployees() throws Exception {

		List<Employee> employeeList = new ArrayList<>();

		Employee employee1 = new Employee(1L, "Zaw", "Lay Pyay Thar", 21, Gender.MALE,
				new Department(1, "Admin", LocalDateTime.now()));

		Employee employee2 = new Employee(2L, "John", "Wick", 23, Gender.MALE,
				new Department(2, "Coding", LocalDateTime.now()));

		employeeList.add(employee1);
		employeeList.add(employee2);
		when(employeeService.findAll()).thenReturn(employeeList);

		mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].firstName", is(employee1.getFirstName())))
				.andExpect(jsonPath("$[0].lastName", is(employee1.getLastName())))
				.andExpect(jsonPath("$[0].age", is(employee1.getAge())))
				.andExpect(jsonPath("$[0].gender", is(employee1.getGender().toString())))
				.andExpect(jsonPath("$[0].department.departmentRes", is(employee1.getDepartment().getDepartmentRes())))
				.andExpect(jsonPath("$[1].firstName", is(employee2.getFirstName())))
				.andExpect(jsonPath("$[1].lastName", is(employee2.getLastName())))
				.andExpect(jsonPath("$[1].age", is(employee2.getAge())))
				.andExpect(jsonPath("$[1].gender", is(employee2.getGender().toString())))
				.andExpect(jsonPath("$[1].department.departmentRes", is(employee2.getDepartment().getDepartmentRes())));

	}

	@Test
	void should_return_api_one_employee() throws Exception {
		Employee employee = new Employee(1L, "John", "Wick", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));

		when(employeeService.findOne(any(Long.class))).thenReturn(employee);

		mockMvc.perform(get("/employee/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
				.andExpect(jsonPath("$.lastName", is(employee.getLastName())))
				.andExpect(jsonPath("$.age", is(employee.getAge())))
				.andExpect(jsonPath("$.gender", is(employee.getGender().toString())))
				.andExpect(jsonPath("$.department.departmentRes", is(employee.getDepartment().getDepartmentRes())));

	}

	@Test
	void should_create_one_employee() throws Exception {
		Employee employee = new Employee(2L, "John", "Wick", 23, Gender.MALE, new Department(1, "Coding", LocalDateTime.now()));

		when(employeeService.save(any(Employee.class))).thenReturn(employee);

		mockMvc.perform(post("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{}")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.firstName", is(employee.getFirstName()))).andExpect(jsonPath("$.age", is(employee.getAge())));

	}

	@Test
	void should_update_one_employee() throws Exception {
		Employee employee = new Employee(1L, "John", "Wick", 23, Gender.MALE, new Department(1, "Coding", LocalDateTime.now()));

		when(employeeService.save(any(Employee.class))).thenReturn(employee);

		mockMvc.perform(put("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{}")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.firstName", is(employee.getFirstName()))).andExpect(jsonPath("$.age", is(employee.getAge())));

	}
	
	@Test
	void should_delete_one_employee() throws Exception {
		
		when(employeeService.removeOne(any(Long.class))).thenReturn(true);
		
		mockMvc.perform(delete("/employee/1")).andDo(print()).andExpect(status().isOk());
		
	}
	
//	@Test
//	void should_delete_one_employee() throws Exception {
//		Employee employee = new Employee(1L, "John", "Wick", 23, Gender.MALE,
//				new Department(1, "Coding", LocalDateTime.now()));
//		
//		doNothing().when(employeeService).removeOne(1L);
//		
//		mockMvc.perform(delete("/employee/1")).andDo(print()).andExpect(status().isOk());
//		
//		verify(employeeService,times(1)).removeOne(employee.getId());;
//		
//		
//	}
	
	@Test
	void should_search_by_first_name() throws Exception {
		
		List<Employee> employeeList = new ArrayList<>();
		
		Employee employee1 = new Employee(1L, "John", "Swanson", 21, Gender.MALE,
				new Department(1, "Admin", LocalDateTime.now()));

		Employee employee2 = new Employee(2L, "John", "Wick", 23, Gender.MALE,
				new Department(2, "Coding", LocalDateTime.now()));
		
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		when(employeeService.searchByFirstName(any(String.class))).thenReturn(employeeList);
		
		mockMvc.perform(get("/employees/searchByFirstName?firstName=John")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].firstName", is(employee1.getFirstName())))
		.andExpect(jsonPath("$[0].lastName", is(employee1.getLastName())))
		.andExpect(jsonPath("$[0].age", is(employee1.getAge())))
		.andExpect(jsonPath("$[0].gender", is(employee1.getGender().toString())))
		.andExpect(jsonPath("$[0].department.departmentRes", is(employee1.getDepartment().getDepartmentRes())))
		.andExpect(jsonPath("$[1].firstName", is(employee2.getFirstName())))
		.andExpect(jsonPath("$[1].lastName", is(employee2.getLastName())))
		.andExpect(jsonPath("$[1].age", is(employee2.getAge())))
		.andExpect(jsonPath("$[1].gender", is(employee2.getGender().toString())))
		.andExpect(jsonPath("$[1].department.departmentRes", is(employee2.getDepartment().getDepartmentRes())));
		
	}
	
	@Test
	void should_get_pagination_employees() throws Exception {
		
		List<Employee> employeeList = new ArrayList<>();
		
		Employee employee1 = new Employee(1L, "John", "Wick", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		Employee employee2 = new Employee(2L, "John", "Swanson", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		Employee employee3 = new Employee(3L, "John", "Swanson", 23, Gender.MALE,
				new Department(1, "Coding", LocalDateTime.now()));
		
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		
		Page<Employee> pageEmployee = new PageImpl<>(employeeList);
				
		when(employeeService.findByPage(any(Pageable.class))).thenReturn(pageEmployee);
		
		mockMvc.perform(get("/employees/findByPage?noPage=0&count=3")).andDo(print()).andExpect(status().isOk());
		
	}
	

}
