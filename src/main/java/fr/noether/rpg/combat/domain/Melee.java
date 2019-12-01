package fr.noether.rpg.combat.domain;

public class Melee extends Fighter {

    public Melee() {
        super(Distance.of(2), Factions.of("Unit"));
    }
}
