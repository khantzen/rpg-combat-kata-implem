package fr.noether.rpg.combat.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FighterShould {

    @Test
    public void start_with_1000_health() {
        Fighter fighter = new Fighter(Distance.of(2));
        assertThat(fighter.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void start_at_level_01() {
        Fighter fighter = new Fighter(Distance.of(2));
        assertThat(fighter.level).isEqualTo(Level.ONE);
    }

    @Test
    public void is_alive_when_health_greater_than_0() {
        Fighter fighter = new Fighter(Distance.of(2));
        assertThat(fighter.isAlive()).isTrue();
    }

    @Test
    public void is_dead_when_health_drops_to_O() {
        Fighter fighter = new Fighter(Distance.of(2));
        fighter.takeDamage(Damage.of(1001));
        assertThat(fighter.isAlive()).isFalse();
    }

    @Test
    public void has_health_remove_when_he_receive_damage() {
        Fighter fighter = new Fighter(Distance.of(2));
        fighter.takeDamage(Damage.of(342));
        assertThat(fighter.health).isEqualTo(Health.of(658));
    }

    @Test
    public void should_receive_heal() {
        Fighter fighter = new Fighter(Distance.of(2));
        fighter.takeDamage(Damage.of(300));
        fighter.receiveHeal(Health.of(200));
        assertThat(fighter.health).isEqualTo(Health.of(900));
    }

    @Test
    public void not_be_healed_over_1000() {
        Fighter fighter = new Fighter(Distance.of(2));
        fighter.takeDamage(Damage.of(200));
        fighter.receiveHeal(Health.of(300));
        assertThat(fighter.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void not_be_healed_when_dead() {
        Fighter fighter = new Fighter(Distance.of(2));
        fighter.takeDamage(Damage.of(1300));
        fighter.receiveHeal(Health.of(300));
        assertThat(fighter.isAlive()).isFalse();
    }

    @Test
    public void be_able_to_join_one_faction() {
        Fighter fighter = new Fighter(Distance.of(2));
        fighter.join(Faction.of("Unit"));
        fighter.join(Faction.of("Test"));
        assertThat(fighter.factions.contains(Faction.of("Unit"))).isTrue();
        assertThat(fighter.factions.contains(Faction.of("Test"))).isTrue();
    }

    @Test
    public void be_able_to_leave_one_faction() {
        Fighter fighter = new Fighter(Distance.of(2));
        fighter.join(Faction.of("Unit"));
        fighter.join(Faction.of("Test"));
        fighter.leave(Faction.of("Unit"));
        assertThat(fighter.factions.contains(Faction.of("Unit"))).isFalse();
        assertThat(fighter.factions.contains(Faction.of("Test"))).isTrue();
    }

    @Test
    public void not_join_the_same_faction_twice() {
        Fighter fighter = new Fighter(Distance.of(2));
        fighter.join(Faction.of("Unit"));
        fighter.join(Faction.of("Unit"));
        assertThat(fighter.factions.contains(Faction.of("Unit"))).isTrue();
        assertThat(fighter.factions.size()).isEqualTo(1);
    }

    @Test
    public void not_be_able_to_heal_an_ennemy_target() {
        Fighter john = new Melee();
        Fighter louis = new Melee();
        Fighter henry = new Ranged();

        john.join(Faction.of("Unit"));
        louis.join(Faction.of("Test"));

        louis.takeDamage(Damage.of(200));
        henry.takeDamage(Damage.of(355));
        john.takeDamage(Damage.of(800));

        john.heal(louis);
        john.heal(henry);
        john.heal(john);

        assertThat(john.health).isEqualTo(Health.of(300));
        assertThat(louis.health).isEqualTo(Health.of(800));
        assertThat(henry.health).isEqualTo(Health.of(645));
    }
}
