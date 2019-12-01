package fr.noether.rpg.combat.domain;

public class Coord {
    private final int line;

    public Coord(int line) {
        this.line = line;
    }

    public static Coord of(int line) {
        return new Coord(line);
    }

    public Distance distanceFrom(Coord position) {
        return Distance.of(Math.abs(this.line - position.line));
    }
}
