package com.jpa.mapping.v1.service;

import com.jpa.mapping.v1.model.Student;
import com.jpa.mapping.v1.model.University;
import com.jpa.mapping.v1.model.request.StudentCreationRequest;
import com.jpa.mapping.v1.model.request.UniversityCreationRequest;
import com.jpa.mapping.v1.repository.StudentRepository;
import com.jpa.mapping.v1.repository.UniversityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UniversityService {

    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;


    public University createUniversity(UniversityCreationRequest request){

        University university = new University();
        log.info(university.getName());
        BeanUtils.copyProperties(request, university);
        log.info(request.getName());
        log.info(university.getName());
        return universityRepository.save(university);
    }

    public Student createStudent(StudentCreationRequest request) {
        Optional<University> university = universityRepository.findById(request.getUniversityId());
        if (!university.isPresent()) {
            throw new EntityNotFoundException("University Not Found");
        }
        Student student = new Student();
        BeanUtils.copyProperties(request,student);
        student.setUniversity(university.get());
        return studentRepository.save(student);
    }

    public List<University> readUniversity(){
        return universityRepository.findAll();
    }


    public List<Student> readStudent(){
        return studentRepository.findAll();
    }



}
