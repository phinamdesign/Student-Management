package com.vsii.service.impl;

import com.vsii.model.Sex;
import com.vsii.repository.SexRepository;
import com.vsii.service.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SexServiceImpl implements SexService {

    @Autowired
    private SexRepository sexRepository;

    @Override
    public Optional<Sex> findById(Long id) {
        return sexRepository.findById(id);
    }

    @Override
    public Iterable<Sex> findAll() {
        return sexRepository.findAll();
    }

    @Override
    public Sex save(Sex sex) {
        return sexRepository.save(sex);
    }

    @Override
    public void delete(Long id) {
        sexRepository.deleteById(id);
    }
}
