package com.vsii.service;

import com.vsii.model.Sex;

import java.util.Optional;

public interface SexService {
    Optional<Sex> findById(Long id);
    Iterable<Sex> findAll();
    Sex save(Sex sex);
    void delete(Long id);
}
