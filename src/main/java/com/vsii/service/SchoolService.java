package com.vsii.service;

import com.vsii.model.School;

import java.util.Optional;

public interface SchoolService {
    Optional<School> findById(Long id);
    Iterable<School> findAll();
    School save(School school);
    void delete(Long id);
}
