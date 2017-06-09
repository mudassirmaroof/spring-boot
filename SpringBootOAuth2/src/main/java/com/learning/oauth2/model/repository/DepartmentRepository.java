package com.learning.oauth2.model.repository;

import com.learning.oauth2.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mudassir on 18/01/2017.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
}
