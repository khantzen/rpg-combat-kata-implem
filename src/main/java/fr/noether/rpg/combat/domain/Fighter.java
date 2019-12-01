package fr.noether.rpg.combat.domain;

public class Fighter {
    private final Distance range;
    public Factions factions;
    public Health health;
    public Level level;
    public Coord position;

    public Fighter(
            Distance range
    ) {
        this.health = Health.THOUSAND;
        this.level = Level.ONE;
        this.range = range;
        this.position = Coord.of(0);
        this.factions = Factions.empty();
    }

    public boolean isAlive() {
        return !health.equals(Health.ZERO);
    }

    public void takeDamage(Damage damage) {
        Health healthToRemove = damage.toHealth();
        this.health = this.health.remove(healthToRemove);
    }

    public void heal(Fighter target) {
        if (this == target) {
            this.receiveHeal(Health.HUNDRED);
        }

        if (this.isAlliedTo(target)) {
            target.receiveHeal(Health.HUNDRED);
        }
    }

    public void receiveHeal(Health heal) {
        if (this.isAlive()) {
            this.health = Health.minimumOf(Health.THOUSAND, this.health.add(heal));
        }
    }

    public void attack(Fighter target) {
        if (this == target || this.isAlliedTo(target)) {
            return;
        }

        Distance distanceBetweenAttackerAndTarget =
                this.position.distanceFrom(target.position);

        if (distanceBetweenAttackerAndTarget.isLessOrEqualThan(range)) {
            float damageModifier = Level.modifier(level, target.level);
            target.takeDamage(Damage.HUNDRED.applyModifier(damageModifier));
        }
    }

    private boolean isAlliedTo(Fighter target) {
        return this.factions.hasCommonWith(target.factions);
    }

    public void join(Faction faction) {
        this.factions = this.factions.append(faction);
    }

    public void leave(Faction faction) {
        this.factions = this.factions.remove(faction);
    }
}
