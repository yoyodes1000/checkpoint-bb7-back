package com.checkpoint.bb7.Team;

import com.checkpoint.bb7.player.Player;
import com.checkpoint.bb7.player.PlayerRepository;
import com.checkpoint.bb7.race.Race;
import com.checkpoint.bb7.race.RaceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team getById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(
                        ()-> new EntityNotFoundException("l'équipe avec l'id " + id + " n'a pas été trouvée")
                );
    }

    public Team create(Team team, Long raceId) {
        Race existingRace = raceRepository.findById(raceId)
                .orElseThrow(
                        ()-> new EntityNotFoundException("la race avec l'id " + raceId + " n'a pas été trouvée")
                );
        team.setRace(existingRace);

        return teamRepository.save(team);
    }

    public Team update(Team team, Long teamId) {
        Team newTeam = getById(teamId);
        newTeam.setNom(team.getNom());
        newTeam.setTresorerie(team.getTresorerie());
        newTeam.setCheerleader(team.getCheerleader());
        newTeam.setAssistant(team.getAssistant());
        newTeam.setApothicaire(team.getApothicaire());
        newTeam.setRelance(team.getRelance());

        return teamRepository.save(newTeam);
    }

    public Team addPlayer(Long teamId, Long playerId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("team with id " + teamId + " not found. 😤☹️"));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("player with id " + playerId + " not found. 😤☹️"));

        team.getPlayers().add(player);

        return teamRepository.save(team);
    }

    public void delete(Long teamId) {
        teamRepository.deleteById(teamId);
    }

    public Team deletePlayer(Long teamId, Long playerId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("team with id " + teamId + " not found. 😤☹️"));
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("player with id " + playerId + " not found. 😤☹️"));
        team.getPlayers().remove(player);
        return teamRepository.save(team);
    }
}
