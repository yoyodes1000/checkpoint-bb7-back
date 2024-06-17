package com.checkpoint.bb7.race;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;


    public List<Race> getAll() {
        return raceRepository.findAll();
    }

    public Race getById(Long id) {
        return raceRepository.findById(id)
                .orElseThrow(
                        ()-> new EntityNotFoundException("la race avec l'id " + id + " n'a pas été trouvée")
                );
    }
}
