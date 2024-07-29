package com.ty.employee_tracker.service;

import java.util.List;

import com.ty.employee_tracker.dto.Employeedto;

public interface EmployeeService {
	
	public List<Employeedto> getAllEmployees();

	public Employeedto createEmployee(Employeedto employee);

	public Employeedto getEmployeeById(Long employeeId);

	public Employeedto updateEmployee(Long employeeId, Employeedto employeedto);

	public String deleteEmployee(Long employeeId);
}
