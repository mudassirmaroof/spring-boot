package com.learning.oauth2.service;


import com.learning.oauth2.model.entity.Department;
import com.learning.oauth2.model.entity.Employee;

import java.util.List;

/**
 * Created by mudassir on 18/01/2017.
 */
public interface DepartmentService {

    List<Department> getDepartments();
    Department getDepartmentById(Long id);
    Department createDepartment(Department department);
    List<Employee> getEmployees(Long id);

}
