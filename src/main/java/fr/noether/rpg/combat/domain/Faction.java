package fr.noether.rpg.combat.domain;

import java.util.Objects;

public class Faction {
    private final String name;

    Faction(String name) {
        this.name = name;
    }

    public static Faction of(String name) {
        return new Faction(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faction faction = (Faction) o;
        return Objects.equals(name, faction.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
