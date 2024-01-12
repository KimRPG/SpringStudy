package com.jpa.mapping.controller;

import com.jpa.mapping.model.University;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MappingController {

    @GetMapping("/api/v1/universities")
    public ResponseEntity<List<University>> universityResponseEntity(){

        return ResponseEntity.ok().build();

    }

}
