package com.vsii.service.impl;

import com.vsii.model.School;
import com.vsii.repository.SchoolRepository;
import com.vsii.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public Optional<School> findById(Long id) {
        return schoolRepository.findById(id);
    }

    @Override
    public Iterable<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }
}
