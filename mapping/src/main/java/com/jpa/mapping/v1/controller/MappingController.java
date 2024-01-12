package com.jpa.mapping.v1.controller;

import com.jpa.mapping.v1.model.Student;
import com.jpa.mapping.v1.model.University;
import com.jpa.mapping.v1.model.request.StudentCreationRequest;
import com.jpa.mapping.v1.model.request.UniversityCreationRequest;
import com.jpa.mapping.v1.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class MappingController {

    private final UniversityService universityService;

    @GetMapping("/universities")
    public ResponseEntity<List<University>> readUniversities(){
        return ResponseEntity.ok(universityService.readUniversity());
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> readStudents(){
        return ResponseEntity.ok(universityService.readStudent());
    }

    @PostMapping("/university")
    public ResponseEntity<University> createUniversity(@RequestBody UniversityCreationRequest request) {
        return ResponseEntity.ok(universityService.createUniversity(request));
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody StudentCreationRequest request) {
        return ResponseEntity.ok(universityService.createStudent(request));
    }

}
