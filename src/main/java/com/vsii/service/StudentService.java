package com.vsii.service;

import com.vsii.model.Student;

import java.util.Optional;

public interface StudentService {
    Optional<Student> findById(Long id);
    Iterable<Student> findAll();
    Student save(Student student);
    void delete(Long id);
}
