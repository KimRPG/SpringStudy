package com.jpa.mapping.v1.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentCreationRequest {

    private String name;
    private String major;
    private Long universityId;
}
