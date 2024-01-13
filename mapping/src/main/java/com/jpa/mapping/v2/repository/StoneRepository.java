package com.jpa.mapping.v2.repository;

import com.jpa.mapping.v2.model.Pocket;
import com.jpa.mapping.v2.model.Stone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoneRepository extends JpaRepository<Stone, Long> {
}