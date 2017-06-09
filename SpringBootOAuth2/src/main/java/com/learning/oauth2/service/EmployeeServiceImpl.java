package com.learning.oauth2.service;


import com.learning.oauth2.model.entity.Employee;
import com.learning.oauth2.model.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mudassir on 06/01/2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {this.employeeRepository = employeeRepository;}


    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.find();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee getEmployeeByIdWithDetails(Long id) {
        return employeeRepository.findByIdWithDetails(id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }
}
