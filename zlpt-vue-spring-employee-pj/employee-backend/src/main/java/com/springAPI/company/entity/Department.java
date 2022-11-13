package com.springAPI.company.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
@Entity
public class Department {

	@Id
	@Column(nullable = false)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String departmentRes;
	
	@Column(columnDefinition = "Date")
	private LocalDateTime createdAt;

	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(Integer id, String departmentRes, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.departmentRes = departmentRes;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentRes() {
		return departmentRes;
	}

	public void setDepartmentRes(String departmentRes) {
		this.departmentRes = departmentRes;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
