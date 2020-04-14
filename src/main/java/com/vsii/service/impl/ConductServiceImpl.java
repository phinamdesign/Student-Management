package com.vsii.service.impl;

import com.vsii.model.Conduct;
import com.vsii.repository.ConductRepository;
import com.vsii.service.ConductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConductServiceImpl implements ConductService {

    @Autowired
    private ConductRepository conductRepository;

    @Override
    public Optional<Conduct> findById(Long id) {
        return conductRepository.findById(id);
    }

    @Override
    public Iterable<Conduct> findAll() {
        return conductRepository.findAll();
    }

    @Override
    public Conduct save(Conduct conduct) {
        return conductRepository.save(conduct);
    }

    @Override
    public void delete(Long id) {
        conductRepository.deleteById(id);
    }
}
