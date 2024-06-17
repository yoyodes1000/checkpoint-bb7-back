package com.checkpoint.bb7.race;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/race")
@RequiredArgsConstructor
public class RaceController {

    @Autowired
    private RaceService raceService;
    @GetMapping("/all")
    public ResponseEntity<List<RaceDTO>> getAll() {
        List<Race> races = raceService.getAll();
        List<RaceDTO> raceDTOS = races.stream().map(RaceDTO::mapFromEntity).toList();
        return new ResponseEntity<>(raceDTOS, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RaceDTO> getById(@PathVariable Long id) {
        Race existingRace = raceService.getById(id);
        RaceDTO raceDTO = RaceDTO.mapFromEntity(existingRace);
        return new ResponseEntity<>(raceDTO, HttpStatus.OK);
    }
}
