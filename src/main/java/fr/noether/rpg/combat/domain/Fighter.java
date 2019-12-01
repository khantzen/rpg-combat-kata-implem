package fr.noether.rpg.combat.domain;

public class Fighter {
    private final Distance range;
    public Health health;
    public Level level;
    public Coord position;

    public Fighter(Distance range) {
        this.health = Health.THOUSAND;
        this.level = Level.ONE;
        this.range = range;
        this.position = Coord.of(0);
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

    public void attack(Fighter target) {
        if (this != target) {
            Distance distanceBetweenAttackerAndTarget =
                    this.position.distanceFrom(target.position);

            if (distanceBetweenAttackerAndTarget.isLowerThan(range)) {
                float damageModifier = Level.modifier(level, target.level);
                target.takeDamage(Damage.HUNDRED.applyModifier(damageModifier));
            }
        }
    }
}
