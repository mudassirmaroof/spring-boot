package com.learning.model.repository;

import com.learning.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mudassir on 07/02/2017.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByEmployee_IdAndCategory(Long id, String category);
}
