package com.ty.employee_tracker.service;

import java.util.List;

import com.ty.employee_tracker.dto.Employeedto;

public interface EmployeeService {
	
	public List<Employeedto> getAllEmployees();

	public Employeedto createEmployee(Employeedto employee);

	public Employeedto getEmployeeById(Long employee_id);

	public Employeedto updateEmployee(Long employee_id, Employeedto employeedto);

	public String deleteEmployee(Long employee_id);
}
