package com.vsii.service;

import com.vsii.model.Address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> findById(Long id);
    Iterable<Address> findAll();
    Address save(Address address);
    void delete(Long id);
}
