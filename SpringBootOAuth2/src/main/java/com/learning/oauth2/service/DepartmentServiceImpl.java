package com.learning.oauth2.service;


import com.learning.oauth2.model.entity.Department;
import com.learning.oauth2.model.entity.Employee;
import com.learning.oauth2.model.repository.DepartmentRepository;
import com.learning.oauth2.model.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mudassir on 18/01/2017.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                                 EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.saveAndFlush(department);
    }

    @Override
    public List<Employee> getEmployees(Long id) {
        return employeeRepository.findByDepartment_Id(id);
    }
}
