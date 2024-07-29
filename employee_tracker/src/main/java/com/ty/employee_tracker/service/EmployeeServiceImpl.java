package com.ty.employee_tracker.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.employee_tracker.Repository.EmployeeRepository;
import com.ty.employee_tracker.dto.Employeedto;
import com.ty.employee_tracker.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employeedto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Employeedto createEmployee(Employeedto employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        employee = employeeRepository.save(employee);
        return convertToDto(employee);
    }

    @Override
    public Employeedto getEmployeeById(Long employee_id) {
        Optional<Employee> employee = employeeRepository.findById(employee_id)
;
        return employee.map(this::convertToDto).orElse(null);
    }

    @Override
    public Employeedto updateEmployee(Long employee_id, Employeedto employeedto) {
        if (employeeRepository.existsById(employee_id)) {
            Employee employee = convertToEntity(employeedto);
            employee.setEmployee_id(employee_id)
;
            employee = employeeRepository.save(employee);
            return convertToDto(employee);
        }
        return null;
    }

    @Override
    public String deleteEmployee(Long employee_id) {
        if (employeeRepository.existsById(employee_id)) {
            employeeRepository.deleteById(employee_id)
;
            return "Deleted Successfully";
        }
        return "No Employee Found";
    }

  
    private Employeedto convertToDto(Employee employee) {
        Employeedto employeedto = new Employeedto();
        employeedto.setEmployee_id(employee.getEmployee_id());
        employeedto.setFirst_Name(employee.getFirst_Name());
        employeedto.setLast_Name(employee.getLast_Name());
        employeedto.setEmail_id(employee.getEmail_id());
        return employeedto;
    }

    private Employee convertToEntity(Employeedto employeedto) {
        Employee employee = new Employee();
        employee.setEmployee_id(employeedto.getEmployee_id());
        employee.setFirst_Name(employeedto.getFirst_Name());
        employee.setLast_Name(employeedto.getLast_Name());
        employee.setEmail_id(employeedto.getEmail_id());
        return employee;
    }
}