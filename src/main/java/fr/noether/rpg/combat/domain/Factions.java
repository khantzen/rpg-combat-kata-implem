package fr.noether.rpg.combat.domain;

public class Factions {
    private final String factions;

    public Factions(String unit) {
        this.factions = unit;
    }

    public static Factions of(String unit) {
        return new Factions(unit);
    }
}
