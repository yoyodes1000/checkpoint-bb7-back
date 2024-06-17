package com.checkpoint.bb7.player;

import com.checkpoint.bb7.Team.Team;
import com.checkpoint.bb7.race.Race;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nb_max", columnDefinition = "INT", nullable = false)
    private Long nbMax;

    @Column(name = "poste", columnDefinition = "VARCHAR(50)", nullable = false)
    private String poste;

    @Column(name = "cout", columnDefinition = "INT", nullable = false)
    private Long cout;

    @Column(name = "comp_mvmt", columnDefinition = "INT", nullable = false)
    private Long compMvmt;

    @Column(name = "comp_force", columnDefinition = "INT", nullable = false)
    private Long compForce;

    @Column(name = "comp_agilite", columnDefinition = "VARCHAR(5)", nullable = false)
    private String compAgilite;

    @Column(name = "comp_passe", columnDefinition = "VARCHAR(5)", nullable = false)
    private String compPasse;

    @Column(name = "comp_armure", columnDefinition = "VARCHAR(5)", nullable = false)
    private String compArmure;

    @Column(name = "principale", columnDefinition = "VARCHAR(5)", nullable = false)
    private String principale;

    @Column(name = "secondaire", columnDefinition = "VARCHAR(5)", nullable = false)
    private String secondaire;

    @Column(name = "comp", columnDefinition = "TEXT", nullable = false)
    private String comp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToMany(mappedBy = "players")
    private List<Team> teams = new ArrayList<>();

}
// @ManyToMany(cascade = CascadeType.ALL)
// private List<Profile> profiles = new ArrayList<>();