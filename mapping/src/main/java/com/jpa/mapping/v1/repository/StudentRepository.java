package com.jpa.mapping.repository;

import com.jpa.mapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {
}
