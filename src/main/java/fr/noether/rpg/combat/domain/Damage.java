package fr.noether.rpg.combat.domain;

public class Damage {
    private final int value;

    private Damage(int value) {
        this.value = value;
    }

    public static Damage of(int value) {
        return new Damage(value);
    }

    Health toHealth() {
        return Health.of(value);
    }
}
