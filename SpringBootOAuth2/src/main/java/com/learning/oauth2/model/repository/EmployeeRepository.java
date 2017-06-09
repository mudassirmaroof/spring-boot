package com.learning.oauth2.model.repository;

import com.learning.oauth2.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mudassir on 04/01/2017.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> find();
    Employee findById(@Param("id") Long id);
    List<Employee> findByDepartment_Id(@Param("id") Long id);
    Employee findByIdWithDetails(@Param("id") Long id);
}
