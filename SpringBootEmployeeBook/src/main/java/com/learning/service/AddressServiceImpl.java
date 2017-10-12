package com.learning.service;

import com.learning.model.entity.Address;
import com.learning.model.repository.AddressRepository;
import org.springframework.stereotype.Service;

/**
 * Created by mudassir on 07/02/2017.
 */
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findOne(id);
    }

    @Override
    public Address getAddressByEmployeeAndCategory(Long id, String category) {
        return addressRepository.findByEmployee_IdAndCategory(id, category);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.saveAndFlush(address);
    }
}
