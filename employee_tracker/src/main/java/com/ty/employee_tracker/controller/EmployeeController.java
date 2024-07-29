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


@RestController
@CrossOrigin("http://localhost:3000")
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
		public List<Employeedto> getAllEmployees() {
			return employeeService.getAllEmployees();
		}
	
	    @GetMapping("/get/{employee_id}")
	    public ResponseEntity<Employeedto> getEmployeeById(@PathVariable Long employee_id) {
	        Employeedto employee = employeeService.getEmployeeById(employee_id);
	        if (employee != null) {
	            return ResponseEntity.ok(employee);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/update/{employee_id}")
	    
	    public ResponseEntity<Employeedto> updateEmployee(@PathVariable Long employee_id, @RequestBody Employeedto employeedto) {
	        Employeedto updatedEmployee = employeeService.updateEmployee(employee_id, employeedto);
	        if (updatedEmployee != null) {
	            return ResponseEntity.ok(updatedEmployee);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	       
	    }
	    
	   
	    @DeleteMapping("/delete/{employee_id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable Long employee_id) {
	        String result = employeeService.deleteEmployee(employee_id);
	        if (result.equals("Deleted Successfully")) {
	            return ResponseEntity.ok(result);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}
