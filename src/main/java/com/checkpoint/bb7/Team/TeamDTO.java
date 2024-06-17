package com.checkpoint.bb7.Team;
public record TeamDTO(
        String nom,
        Long tresorerie,
        Long cheerleader,
        Long assistant,
        Long apothicaire,
        Long relance
) {
    public static TeamDTO mapFromEntity(Team team) {
        return new TeamDTO(
             team.getNom(),
             team.getTresorerie(),
             team.getCheerleader(),
             team.getAssistant(),
             team.getApothicaire(),
             team.getRelance()
        );
    }
}
