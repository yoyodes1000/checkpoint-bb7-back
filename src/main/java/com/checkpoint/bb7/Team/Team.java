package com.checkpoint.bb7.Team;

import com.checkpoint.bb7.race.Race;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id")
    private Race race;
}
