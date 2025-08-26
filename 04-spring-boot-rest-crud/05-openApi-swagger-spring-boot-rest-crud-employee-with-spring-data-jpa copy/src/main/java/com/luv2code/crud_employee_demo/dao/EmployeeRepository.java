package com.luv2code.crud_employee_demo.dao;

import com.luv2code.crud_employee_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that is it... no need to write any other code.
}
