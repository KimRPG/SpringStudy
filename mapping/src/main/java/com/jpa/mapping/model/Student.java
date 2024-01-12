package com.jpa.mapping.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;

    private String name;
    private String major;

    @ManyToOne
    @JoinColumn(name = "university_id")
    @JsonManagedReference
    private University university;

}
