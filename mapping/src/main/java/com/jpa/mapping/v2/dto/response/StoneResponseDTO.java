package com.jpa.mapping.v2.dto.response;

import com.jpa.mapping.v2.model.Pocket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoneResponseDTO {

    private int id;
    private String stoneName;
    private Pocket pocket;
}
