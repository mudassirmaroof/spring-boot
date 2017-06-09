package com.learning.oauth2.service;


import com.learning.oauth2.model.entity.Address;

/**
 * Created by mudassir on 07/02/2017.
 */
public interface AddressService {
    Address getAddressById(Long id);
    Address getAddressByEmployeeAndCategory(Long id, String category);
    Address saveAddress(Address address);
}
