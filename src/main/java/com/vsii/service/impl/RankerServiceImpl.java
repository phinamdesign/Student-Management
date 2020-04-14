package com.vsii.service.impl;

import com.vsii.model.Ranker;
import com.vsii.repository.RankerRepository;
import com.vsii.service.RankerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RankerServiceImpl implements RankerService {

    @Autowired
    private RankerRepository rankerRepository;

    @Override
    public Optional<Ranker> findById(Long id) {
        return rankerRepository.findById(id);
    }

    @Override
    public Iterable<Ranker> findAll() {
        return rankerRepository.findAll();
    }

    @Override
    public Ranker save(Ranker ranker) {
        return rankerRepository.save(ranker);
    }

    @Override
    public void delete(Long id) {
        rankerRepository.deleteById(id);
    }
}
