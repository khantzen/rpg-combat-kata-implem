package fr.noether.rpg.combat.domain;

import java.util.Objects;

public class Level {
    public static final Level ONE = of(1);
    private final int level;

    public Level(int level) {
        this.level = level;
    }

    public static Level of(int level) {
        return new Level(level);
    }

    public static float modifier(Level attacker, Level defender) {
        float modifier = 1f;

        if (defender.level - attacker.level >= 5) {
            modifier = 0.5f;
        }

        return modifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level1 = (Level) o;
        return level == level1.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}
