package com.luv2code.crud_employee_demo.dao;

import com.luv2code.crud_employee_demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save the employee
        // merge: if id == 0, it saves a new employee. If not, updates the existing employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return the employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
