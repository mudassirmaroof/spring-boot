package com.learning.controller;

import com.learning.model.dto.response.DepartmentsResponse;
import com.learning.model.dto.response.EmployeesResponse;
import com.learning.model.entity.Department;
import com.learning.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mudassir on 18/01/2017.
 */
@RestController
@RequestMapping ("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity get() {
        return new ResponseEntity<DepartmentsResponse>(new DepartmentsResponse(departmentService.getDepartments()), HttpStatus.OK);
    }

    @RequestMapping (value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id);
        if (ObjectUtils.isEmpty(department)) {
            return new ResponseEntity<DepartmentsResponse>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DepartmentsResponse>(new DepartmentsResponse(department), HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.POST)
    public ResponseEntity create(@Validated @RequestBody Department department) {
        return new ResponseEntity<DepartmentsResponse>(new DepartmentsResponse(departmentService.createDepartment(department)), HttpStatus.OK);
    }

    @RequestMapping (value = "/{id}/employees",
            method = RequestMethod.GET)
    public ResponseEntity getEmployees(@PathVariable Long id) {
        return new ResponseEntity<EmployeesResponse>(new EmployeesResponse(departmentService.getEmployees(id)), HttpStatus.OK);
    }
}
