package com.jpa.mapping.v1.repository;

import com.jpa.mapping.v1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {
}
