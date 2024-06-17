package com.checkpoint.bb7.Team;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("all")
    public ResponseEntity<List<TeamDTO>> getAll() {
        List<Team> teams = teamService.getAll();
        List<TeamDTO> teamDTOS = teams.stream().map(TeamDTO::mapFromEntity).toList();
        return new ResponseEntity<>(teamDTOS, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamDTO> getById(@PathVariable Long id) {
        Team existingTeam = teamService.getById(id);
        TeamDTO teamDTO = TeamDTO.mapFromEntity(existingTeam);
        return (new ResponseEntity<>(teamDTO, HttpStatus.OK));
    }

    @PostMapping("create/race/{raceId}")
    public ResponseEntity<TeamDTO> create(@RequestBody Team team,
                                          @PathVariable Long raceId
                                              ) {
        Team newTeam = teamService.create(team, raceId);
        TeamDTO teamDTO =TeamDTO.mapFromEntity(newTeam);
        return new ResponseEntity<>(teamDTO, HttpStatus.CREATED);
    }

    @PostMapping("add/{teamId}/player/{playerId}")
    public ResponseEntity<TeamDTO> addPlayer(@PathVariable Long teamId,
                                             @PathVariable Long playerId) {
        teamService.addPlayer(teamId, playerId);

        Team team = teamService.getById(teamId);
        TeamDTO teamDTO = TeamDTO.mapFromEntity(team);

        return new ResponseEntity<>(teamDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{teamId}")
    public ResponseEntity<TeamDTO> update(@RequestBody Team team,
                                          @PathVariable Long teamId) {
         Team newTeam = teamService.update(team, teamId);
         TeamDTO teamDTO = TeamDTO.mapFromEntity(newTeam);
         return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teamId}")
    public ResponseEntity<Void> delete(@PathVariable Long teamId) {
        teamService.delete(teamId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{teamId}/player/{playerId}")
    public ResponseEntity<Team> delete(@PathVariable Long teamId,
                                       @PathVariable Long playerId) {
        Team newTeam = teamService.deletePlayer(teamId, playerId);
        return new ResponseEntity<>(newTeam, HttpStatus.NO_CONTENT);
    }

//    @DeleteMapping("/delete/{teamId}/player/{playerId}")
//    public ResponseEntity<Void> deletePlayer(@PathVariable Long teamId, @PathVariable Long playerId) {
//        teamService.deletePlayer(teamId, playerId);
//
//        Team team = teamService.getById(teamId);
//        TeamDTO teamDTO = TeamDTO.mapFromEntity(team);
//    }
}
