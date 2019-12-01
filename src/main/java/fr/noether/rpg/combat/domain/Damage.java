package fr.noether.rpg.combat.domain;

public class Damage {
    public static final Damage HUNDRED = of(100);
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

    public Damage applyModifier(float damageModifier) {
        return Damage.of((int) (value * damageModifier));
    }
}
