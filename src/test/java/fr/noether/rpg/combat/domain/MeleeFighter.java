package fr.noether.rpg.combat.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MeleeFighter {

    @Test
    public void cant_attack_more_than_2_range() {
        Melee john = new Melee();
        Melee louis = new Melee();
        john.position = Coord.of(0);
        louis.position = Coord.of(5);

        john.attack(louis);
        Assertions.assertThat(louis.health).isEqualTo(Health.of(1000));
    }
}
