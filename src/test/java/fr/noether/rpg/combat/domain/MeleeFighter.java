package fr.noether.rpg.combat.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MeleeFighter {

    @Test
    public void cant_attack_more_than_2_range() {
        Melee john = new Melee();
        Melee louis = new Melee();
        john.position = Coord.of(0);
        louis.position = Coord.of(5);

        john.attack(louis);
        assertThat(louis.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void can_attack_when_enemy_is_in_range() {
        Melee john = new Melee();
        Melee louis = new Melee();
        john.position = Coord.of(0);
        louis.position = Coord.of(2);

        john.attack(louis);
        assertThat(louis.health).isEqualTo(Health.of(900));
    }
}
