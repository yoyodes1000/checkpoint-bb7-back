package com.checkpoint.bb7.player;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @GetMapping("/all")
    public ResponseEntity<List<PlayerDTO>> getAll() {
         List<Player> players = playerService.getAll();
         List<PlayerDTO> playerDTOS = players.stream().map(PlayerDTO::mapFromEntity).toList();
         return new ResponseEntity<>(playerDTOS, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerDTO> getById(@PathVariable Long id) {
        Player existingPlayer = playerService.getById(id);
        PlayerDTO playerDTO = PlayerDTO.mapFromEntity(existingPlayer);
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }
}
