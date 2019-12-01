package fr.noether.rpg.combat.domain;

import java.util.logging.Level;

public class Character {
    public Health health;
    public Level level;

    public Character() {
        this.health = Health.THOUSAND;
    }

    public boolean isAlive() {
        return !health.equals(Health.ZERO);
    }

    public void takeDamage(Damage damage) {
        this.health = Health.ZERO;
    }
}
