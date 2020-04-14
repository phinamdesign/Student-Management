package com.vsii.repository;

import com.vsii.model.Ranker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankerRepository extends JpaRepository<Ranker, Long> {
}
