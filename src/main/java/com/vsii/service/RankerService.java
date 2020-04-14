package com.vsii.service;

import com.vsii.model.Ranker;

import java.util.Optional;

public interface RankerService {
    Optional<Ranker> findById(Long id);
    Iterable<Ranker> findAll();
    Ranker save(Ranker ranker);
    void delete(Long id);
}
