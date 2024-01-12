package com.jpa.mapping.service;

import com.jpa.mapping.repository.StudentRepository;
import com.jpa.mapping.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;






}
