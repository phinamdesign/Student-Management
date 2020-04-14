package com.vsii.service;

import com.vsii.model.Conduct;

import java.util.Optional;

public interface ConductService {
    Optional<Conduct> findById(Long id);
    Iterable<Conduct> findAll();
    Conduct save(Conduct conduct);
    void delete(Long id);
}
