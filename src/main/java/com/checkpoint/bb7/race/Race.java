package com.checkpoint.bb7.race;

import com.checkpoint.bb7.Team.Team;
import com.checkpoint.bb7.player.Player;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", columnDefinition = "VARCHAR(50)", nullable = false)
    private String nom;

    @Column(name = "relance", columnDefinition = "INT", nullable = false)
    private Long relance;

    @Column(name = "apothicaire", nullable = false)
    private boolean apothicaire = true;

    @OneToMany(mappedBy = "race")
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "race")
    private List<Team> teams = new ArrayList<>();
}
