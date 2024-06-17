package com.checkpoint.bb7.player;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    public Player getById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(
                        ()-> new EntityNotFoundException("le joueur avec l'id " + id + " n'a pas été trouvé")
                );
    }
}
