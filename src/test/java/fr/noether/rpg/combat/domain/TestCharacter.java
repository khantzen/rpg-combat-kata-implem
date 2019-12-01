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
}
