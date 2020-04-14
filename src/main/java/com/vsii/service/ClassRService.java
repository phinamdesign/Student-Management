package com.vsii.service;

import com.vsii.model.ClassR;

import java.util.Optional;

public interface ClassRService {
    Optional<ClassR> findById(Long id);
    Iterable<ClassR> findAll();
    ClassR save(ClassR classR);
    void delete(Long id);
}
