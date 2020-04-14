package com.vsii.repository;

import com.vsii.model.ClassR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRRepository extends JpaRepository<ClassR, Long> {
}
