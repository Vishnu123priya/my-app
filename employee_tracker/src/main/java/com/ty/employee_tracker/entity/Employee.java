package com.ty.employee_tracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employee_id;

	@Column(name = "first_name")
	private String first_Name;

	@Column(name = "last_name")
	private String last_Name;

	@Column(name = "email_id")
	private String email_id;

	
	

	public Employee(Long employee_id, String first_Name, String last_Name, String email_id) {
		super();
		this.employee_id = employee_id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email_id = email_id;
	}




	public Long getEmployee_id() {
		return employee_id;
	}




	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}




	public String getFirst_Name() {
		return first_Name;
	}




	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}




	public String getLast_Name() {
		return last_Name;
	}




	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}




	public String getEmail_id() {
		return email_id;
	}




	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}




	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}




	

}