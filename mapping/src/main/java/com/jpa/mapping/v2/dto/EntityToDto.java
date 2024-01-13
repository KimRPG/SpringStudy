package com.jpa.mapping.v2.dto;

import com.jpa.mapping.v2.dto.response.PocketResponseDTO;
import com.jpa.mapping.v2.dto.response.StoneResponseDTO;
import com.jpa.mapping.v2.model.Pocket;
import com.jpa.mapping.v2.model.Stone;

import java.util.ArrayList;
import java.util.List;

public class EntityToDto {

    public static StoneResponseDTO bookToBookResponseDTO(Stone stone) {
        StoneResponseDTO stoneResponseDTO = new StoneResponseDTO();
        stoneResponseDTO.setId(stone.getId());
        stoneResponseDTO.setStoneName(stone.getStoneName());
        stoneResponseDTO.setPocket(stone.getPocket());
        return stoneResponseDTO;
    }

    public static List<StoneResponseDTO> bookToBookResponseDTOs(List<Stone> stones) {
        List<StoneResponseDTO> stoneResponseDTOs = new ArrayList<>();
        for (Stone stone : stones) {
            stoneResponseDTOs.add(bookToBookResponseDTO(stone));
        }
        return stoneResponseDTOs;
    }

    public static PocketResponseDTO categoryToCategoryDTO(Pocket pocket) {
        PocketResponseDTO pocketResponseDTO = new PocketResponseDTO();
        pocketResponseDTO.setId(pocket.getId());
        pocketResponseDTO.setPocketColor(pocket.getPocketColor());
        pocketResponseDTO.setPocketName(pocket.getPocketName());
        List<Stone> stones=pocket.getStones();
        List<Stone> stonesDto = new ArrayList<>(stones);
        pocketResponseDTO.setStones(stonesDto);
        return pocketResponseDTO;
    }

    public static List<PocketResponseDTO> pocketResponseDTOs(List<Pocket> pockets) {
        List<PocketResponseDTO> pocketResponseDTOs = new ArrayList<>();
        for (Pocket pocket : pockets) {
            pocketResponseDTOs.add(categoryToCategoryDTO(pocket));
        }
        return pocketResponseDTOs;
    }
}
