package com.jpa.mapping.repository;

import com.jpa.mapping.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}
