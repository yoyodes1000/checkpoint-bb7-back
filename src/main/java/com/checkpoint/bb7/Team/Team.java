package com.checkpoint.bb7.Team;

import com.checkpoint.bb7.player.Player;
import com.checkpoint.bb7.race.Race;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", columnDefinition = "VARCHAR(50)", nullable = false)
    private String nom;

    @Column(name = "tresorerie", columnDefinition = "INT", nullable = false)
    private Long tresorerie = 600000L;

    @Column(name = "cheerleader", columnDefinition = "INT", nullable = false)
    private Long cheerleader = 0L;

    @Column(name = "assistant", columnDefinition = "INT", nullable = false)
    private Long assistant = 0L;

    @Column(name = "apothicaire", columnDefinition = "INT", nullable = false)
    private Long apothicaire;

    @Column(name = "relance", columnDefinition = "INT", nullable = false)
    private Long relance;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "team-player",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players = new ArrayList<>();
}
