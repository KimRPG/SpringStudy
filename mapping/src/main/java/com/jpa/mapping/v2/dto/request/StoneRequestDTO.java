package com.jpa.mapping.v2.dto.request;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoneRequestDTO {

    private String stoneName;
    private Long pocketId;
}