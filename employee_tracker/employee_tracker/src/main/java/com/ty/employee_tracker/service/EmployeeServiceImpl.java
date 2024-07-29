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
    public Employeedto getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id)
;
        return employee.map(this::convertToDto).orElse(null);
    }

    @Override
    public Employeedto updateEmployee(Long id, Employeedto employeedto) {
        if (employeeRepository.existsById(id)) {
            Employee employee = convertToEntity(employeedto);
            employee.setId(id)
;
            employee = employeeRepository.save(employee);
            return convertToDto(employee);
        }
        return null;
    }

    @Override
    public String deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id)
;
            return "Deleted Successfully";
        }
        return "No Employee Found";
    }

  
    private Employeedto convertToDto(Employee employee) {
        Employeedto employeedto = new Employeedto();
        employeedto.setId(employee.getId());
        employeedto.setFirstName(employee.getFirstName());
        employeedto.setLastName(employee.getLastName());
        employeedto.setEmail(employee.getEmail());
        return employeedto;
    }

    private Employee convertToEntity(Employeedto employeedto) {
        Employee employee = new Employee();
        employee.setId(employeedto.getId());
        employee.setFirstName(employeedto.getFirstName());
        employee.setLastName(employeedto.getLastName());
        employee.setEmail(employeedto.getEmail());
        return employee;
    }
}