package com.learning.model.repository;

import com.learning.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mudassir on 21/02/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String s);
}
