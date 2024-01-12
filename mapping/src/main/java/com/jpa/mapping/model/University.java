package com.jpa.mapping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Getter
@NoArgsConstructor
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private long id;


    private String name;

    @OneToMany(mappedBy = "university",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Student> student;
}
