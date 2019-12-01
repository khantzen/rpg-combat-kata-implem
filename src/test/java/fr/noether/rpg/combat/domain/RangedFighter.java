package fr.noether.rpg.combat.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RangedFighter {
    @Test
    public void cant_attack_more_than_20_range() {
        Ranged john = new Ranged();
        Ranged louis = new Ranged();

        john.position = Coord.of(0);
        louis.position = Coord.of(39);

        john.attack(louis);
        Assertions.assertThat(louis.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void can_attack_when_enemy_is_in_range() {
        Ranged john = new Ranged();
        Ranged louis = new Ranged();
        john.position = Coord.of(0);
        louis.position = Coord.of(18);

        john.attack(louis);
        Assertions.assertThat(louis.health).isEqualTo(Health.of(900));
    }
}
