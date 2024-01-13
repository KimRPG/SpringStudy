package com.jpa.mapping.v2.repository;

import com.jpa.mapping.v2.model.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PocketRepository extends JpaRepository<Pocket, Long> {
}