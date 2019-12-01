package fr.noether.rpg.combat.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TestCharacter {

    @Test
    public void start_with_1000_health() {
        Character character = new Character();
        Assertions.assertThat(character.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void start_at_level_01() {
        Character character = new Character();
        Assertions.assertThat(character.level).isEqualTo(Level.ONE);
    }

    @Test
    public void is_alive_when_health_greater_than_0() {
        Character character = new Character();
        Assertions.assertThat(character.isAlive()).isTrue();
    }

    @Test
    public void is_dead_when_health_drops_to_O() {
        Character character = new Character();
        character.takeDamage(Damage.of(1001));
        Assertions.assertThat(character.isAlive()).isFalse();
    }

    @Test
    public void has_health_remove_when_he_receive_damage() {
        Character character = new Character();
        character.takeDamage(Damage.of(342));
        Assertions.assertThat(character.health).isEqualTo(Health.of(658));
    }

    @Test
    public void should_receive_heal() {
        Character character = new Character();
        character.takeDamage(Damage.of(300));
        character.receiveHeal(Health.of(200));
        Assertions.assertThat(character.health).isEqualTo(Health.of(900));
    }

    @Test
    public void cannot_be_healed_over_1000() {
        Character character = new Character();
        character.takeDamage(Damage.of(200));
        character.receiveHeal(Health.of(300));
        Assertions.assertThat(character.health).isEqualTo(Health.of(1000));
    }
}
