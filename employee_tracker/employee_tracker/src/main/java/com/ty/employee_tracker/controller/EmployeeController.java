package com.ty.employee_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.employee_tracker.dto.Employeedto;
import com.ty.employee_tracker.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
	
	 @PostMapping("/save")
	    public ResponseEntity<Employeedto> createEmployee(@RequestBody Employeedto employeeDto) {
	        Employeedto createdEmployee = employeeService.createEmployee(employeeDto);
	        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	    }
	 
	  @GetMapping("/all")
	    public ResponseEntity<List<Employeedto>> getAllEmployees() {
	        List<Employeedto> employees = employeeService.getAllEmployees();
	        return ResponseEntity.ok(employees);
	    }

	    @GetMapping("/get/{id}")
	    public ResponseEntity<Employeedto> getEmployeeById(@PathVariable Long id) {
	        Employeedto employee = employeeService.getEmployeeById(id);
	        if (employee != null) {
	            return ResponseEntity.ok(employee);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Employeedto> updateEmployee(@PathVariable Long id, @RequestBody Employeedto employeeDto) {
	        Employeedto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
	        if (updatedEmployee != null) {
	            return ResponseEntity.ok(updatedEmployee);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
	        String result = employeeService.deleteEmployee(id);
	        if (result.equals("Deleted Successfully")) {
	            return ResponseEntity.ok(result);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}
