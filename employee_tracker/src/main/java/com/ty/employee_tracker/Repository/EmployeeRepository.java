package com.ty.employee_tracker.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.employee_tracker.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
