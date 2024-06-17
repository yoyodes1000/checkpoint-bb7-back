package com.checkpoint.bb7.Team;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
