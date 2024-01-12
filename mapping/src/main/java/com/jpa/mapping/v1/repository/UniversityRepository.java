package com.jpa.mapping.v1.repository;

import com.jpa.mapping.v1.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}
