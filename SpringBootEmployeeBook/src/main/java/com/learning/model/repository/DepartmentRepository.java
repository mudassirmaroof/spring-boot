package com.learning.model.repository;

import com.learning.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mudassir on 18/01/2017.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
}
