package fr.noether.rpg.combat.domain;

public class Ranged extends Fighter {
    public Ranged() {
        super(Distance.of(20));
    }
}
