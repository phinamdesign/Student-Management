package com.vsii.service.impl;

import com.vsii.model.ClassR;
import com.vsii.repository.ClassRRepository;
import com.vsii.service.ClassRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRServiceImpl implements ClassRService {

    @Autowired
    private ClassRRepository classRRepository;

    @Override
    public Optional<ClassR> findById(Long id) {
        return classRRepository.findById(id);
    }

    @Override
    public Iterable<ClassR> findAll() {
        return classRRepository.findAll();
    }

    @Override
    public ClassR save(ClassR classR) {
        return classRRepository.save(classR);
    }

    @Override
    public void delete(Long id) {
        classRRepository.deleteById(id);
    }
}
