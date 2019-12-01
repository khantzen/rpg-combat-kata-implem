package fr.noether.rpg.combat.domain;

public class Distance {
    private final int value;

    private Distance(int value) {
        this.value = value;
    }

    public static Distance of(int range) {
        return new Distance(range);
    }

    boolean isLessOrEqualThan(Distance target) {
        return this.value <= target.value;
    }
}
