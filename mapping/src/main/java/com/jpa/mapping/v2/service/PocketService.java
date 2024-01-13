package com.jpa.mapping.v2.service;

import com.jpa.mapping.v2.dto.EntityToDto;
import com.jpa.mapping.v2.dto.request.PocketRequestDTO;
import com.jpa.mapping.v2.dto.request.StoneRequestDTO;
import com.jpa.mapping.v2.dto.response.PocketResponseDTO;
import com.jpa.mapping.v2.dto.response.StoneResponseDTO;
import com.jpa.mapping.v2.model.Pocket;
import com.jpa.mapping.v2.model.Stone;
import com.jpa.mapping.v2.repository.PocketRepository;
import com.jpa.mapping.v2.repository.StoneRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PocketService {

    private final PocketRepository pocketRepository;
    private final StoneRepository stoneRepository;

    public PocketResponseDTO addPocket(PocketRequestDTO dto) {
        Pocket pocket = new Pocket(dto.getPocketName(), dto.getPocketColor());
        pocketRepository.save(pocket);
        return EntityToDto.categoryToCategoryDTO(pocket);
    }

    public StoneResponseDTO addStone(StoneRequestDTO dto) {
        Optional<Pocket> pocket = pocketRepository.findById(dto.getPocketId());
        if (pocket.isEmpty()) {
            throw new EntityNotFoundException("pocket not found");
        }
        Stone stone = new Stone(dto.getStoneName(), pocket.get());
        Stone  stone1=stoneRepository.save(stone);
        return EntityToDto.bookToBookResponseDTO(stone1);
    }

    public List<PocketResponseDTO> readPockets(){
        return EntityToDto.pocketResponseDTOs(pocketRepository.findAll());
    }

    public List<StoneResponseDTO> readStones(){
        return EntityToDto.bookToBookResponseDTOs(stoneRepository.findAll());
    }

}
