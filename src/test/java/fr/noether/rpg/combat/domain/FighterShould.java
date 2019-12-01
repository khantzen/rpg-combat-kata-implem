package fr.noether.rpg.combat.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FighterShould {

    @Test
    public void start_with_1000_health() {
        Fighter fighter = new Fighter(Distance.of(2), Factions.of("Unit"));
        Assertions.assertThat(fighter.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void start_at_level_01() {
        Fighter fighter = new Fighter(Distance.of(2), Factions.of("Unit"));
        Assertions.assertThat(fighter.level).isEqualTo(Level.ONE);
    }

    @Test
    public void is_alive_when_health_greater_than_0() {
        Fighter fighter = new Fighter(Distance.of(2), Factions.of("Unit"));
        Assertions.assertThat(fighter.isAlive()).isTrue();
    }

    @Test
    public void is_dead_when_health_drops_to_O() {
        Fighter fighter = new Fighter(Distance.of(2), Factions.of("Unit"));
        fighter.takeDamage(Damage.of(1001));
        Assertions.assertThat(fighter.isAlive()).isFalse();
    }

    @Test
    public void has_health_remove_when_he_receive_damage() {
        Fighter fighter = new Fighter(Distance.of(2), Factions.of("Unit"));
        fighter.takeDamage(Damage.of(342));
        Assertions.assertThat(fighter.health).isEqualTo(Health.of(658));
    }

    @Test
    public void should_receive_heal() {
        Fighter fighter = new Fighter(Distance.of(2), Factions.of("Unit"));
        fighter.takeDamage(Damage.of(300));
        fighter.receiveHeal(Health.of(200));
        Assertions.assertThat(fighter.health).isEqualTo(Health.of(900));
    }

    @Test
    public void not_be_healed_over_1000() {
        Fighter fighter = new Fighter(Distance.of(2), Factions.of("Unit"));
        fighter.takeDamage(Damage.of(200));
        fighter.receiveHeal(Health.of(300));
        Assertions.assertThat(fighter.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void not_be_healed_when_dead() {
        Fighter fighter = new Fighter(Distance.of(2), Factions.of("Unit"));
        fighter.takeDamage(Damage.of(1300));
        fighter.receiveHeal(Health.of(300));
        Assertions.assertThat(fighter.isAlive()).isFalse();
    }
}
