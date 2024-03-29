package fr.noether.rpg.combat.domain;

import java.util.Objects;

public class Health {
    public static final Health ZERO = of(0);
    public static final Health THOUSAND = of(1000);
    public static final Health HUNDRED = of(100);

    private final int value;

    private Health(int value) {
        this.value = value;
    }

    public static Health of(int value) {
        return new Health(value);
    }

    static Health minimumOf(Health first, Health second) {
        Health minimum = first;
        if (first.value > second.value) {
            minimum = second;
        }
        return minimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Health health = (Health) o;
        return value == health.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    Health remove(Health toHealth) {
        int newHealthValue = Math.max(this.value - toHealth.value, 0);
        return Health.of(newHealthValue);
    }

    Health add(Health heal) {
        return Health.of(this.value + heal.value);
    }
}
