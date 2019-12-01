package fr.noether.rpg.combat.domain;

public class Character {
    public Health health;
    public Level level;

    public Character() {
        this.health = Health.THOUSAND;
        this.level = Level.ONE;
    }

    public boolean isAlive() {
        return !health.equals(Health.ZERO);
    }

    public void takeDamage(Damage damage) {
        Health healthToRemove = damage.toHealth();
        this.health = this.health.remove(healthToRemove);
    }

    public void receiveHeal(Health heal) {
        this.health = Health.minimumOf(Health.THOUSAND, this.health.add(heal));
    }

    public void attack(Character target) {
        if (this != target) {
            float damageModifier = Level.modifier(level, target.level);
            target.takeDamage(Damage.HUNDRED.applyModifier(damageModifier));
        }
    }
}
