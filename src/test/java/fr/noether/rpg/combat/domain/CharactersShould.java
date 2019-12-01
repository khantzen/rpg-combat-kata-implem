package fr.noether.rpg.combat.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CharactersShould {

    @Test
    public void start_with_1000_health() {
        Characters characters = new Characters();
        Assertions.assertThat(characters.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void start_at_level_01() {
        Characters characters = new Characters();
        Assertions.assertThat(characters.level).isEqualTo(Level.ONE);
    }
}
