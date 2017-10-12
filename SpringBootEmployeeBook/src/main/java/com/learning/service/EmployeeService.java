package com.learning.service;

import com.learning.model.entity.Employee;

import java.util.List;

/**
 * Created by mudassir on 06/01/2017.
 */
public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployeeById(Long id);

    Employee getEmployeeByIdWithDetails(Long id);

    Employee createEmployee (Employee employee);

    Employee updateEmployee(Employee employee);
}

