package com.checkpoint.bb7.race;

public record RaceDTO(
        String nom,
        Long relance,
        boolean isApothicaire
) {
    public static RaceDTO mapFromEntity(Race race) {
        return new RaceDTO(
                race.getNom(),
                race.getRelance(),
                race.isApothicaire()
        );
    }
}
