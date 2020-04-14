package com.vsii.repository;

import com.vsii.model.Conduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductRepository extends JpaRepository<Conduct, Long> {
}
