package fr.noether.rpg.combat.domain;

import java.util.HashSet;
import java.util.Set;

public class Factions {
    private final HashSet<Faction> factions;

    private Factions(HashSet<Faction> factions) {
        this.factions = factions;
    }

    private static Factions of(Set<Factions> factions) {
        return new Factions(new HashSet<>());
    }

    static Factions empty() {
        return Factions.of(new HashSet<>());
    }

    boolean haveCommonWith(Factions target) {
        return this.factions.equals(target.factions);
    }

    public int size() {
        return factions.size();
    }

    public boolean contains(Faction target) {
        return factions.contains(target);
    }

    Factions append(Faction faction) {
        factions.add(faction);
        return new Factions(factions);
    }

    Factions remove(Faction toRemove) {
        factions.remove(toRemove);
        return new Factions(factions);
    }

    public boolean hasCommonWith(Factions target) {
        long count = this.factions.stream()
                .filter(target.factions::contains)
                .count();
        return count != 0;
    }
}
