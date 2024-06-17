package com.checkpoint.bb7.player;

public record PlayerDTO(
        Long nbMax,
        String poste,
        Long cout,
        Long compMvmt,
        Long compForce,
        String compAgilite,
        String compPasse,
        String compArmure,
        String principale,
        String secondaire,
        String comp) {
    public static PlayerDTO mapFromEntity(Player player) {
        return new PlayerDTO(
                player.getNbMax(),
                player.getPoste(),
                player.getCout(),
                player.getCompMvmt(),
                player.getCompForce(),
                player.getCompAgilite(),
                player.getCompPasse(),
                player.getCompArmure(),
                player.getPrincipale(),
                player.getSecondaire(),
                player.getComp()
        );
    }
}
