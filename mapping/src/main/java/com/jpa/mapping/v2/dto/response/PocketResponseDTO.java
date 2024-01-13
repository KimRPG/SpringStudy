package com.jpa.mapping.v2.dto.response;

import com.jpa.mapping.v2.model.Stone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PocketResponseDTO {

    private int id;
    private String pocketName;
    private String pocketColor;
    private List<Stone> stones;
}
