package fr.noether.rpg.combat.domain;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Factions {
    static final Factions EMPTY = new Factions(new ArrayList<>());

    private final List<Faction> factions;

    private Factions(List<Faction> factions) {
        this.factions = factions;
    }

    boolean haveCommonWith(Factions target) {
        return this.factions.equals(target.factions);
    }

    public int size() {
        return factions.size();
    }

    public boolean isEmpty() {
        return this.equals(EMPTY);
    }

    public boolean contains(Faction target) {
        return factions.contains(target);
    }

    Factions append(Faction faction) {
        factions.add(faction);
        return new Factions(factions);
    }
}
