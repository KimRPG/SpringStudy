package com.jpa.mapping.v2.controller;

import com.jpa.mapping.v2.dto.request.PocketRequestDTO;
import com.jpa.mapping.v2.dto.request.StoneRequestDTO;
import com.jpa.mapping.v2.dto.response.PocketResponseDTO;
import com.jpa.mapping.v2.dto.response.StoneResponseDTO;
import com.jpa.mapping.v2.service.PocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2")
@RequiredArgsConstructor
public class PocketController {

    private final PocketService pocketService;

    @PostMapping("/pocket")
    public ResponseEntity<PocketResponseDTO> addPocket(@RequestBody PocketRequestDTO dto) {
        return ResponseEntity.ok(pocketService.addPocket(dto));
    }
    @PostMapping("/stone")
    public ResponseEntity<StoneResponseDTO> addPocket(@RequestBody StoneRequestDTO dto) {
        return ResponseEntity.ok(pocketService.addStone(dto));
    }
    @GetMapping("/pockets")
    public ResponseEntity<List<PocketResponseDTO>> readPockets(){
        return ResponseEntity.ok(pocketService.readPockets());
    }
    @GetMapping("/stones")
    public ResponseEntity<List<StoneResponseDTO>> readStones(){
        return ResponseEntity.ok(pocketService.readStones());
    }
}
