package fr.noether.rpg.combat.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CharacterDamage {

    @Test
    public void can_be_inflicted_to_another_character() {
        Character john = new Character();
        Character louis = new Character();
        john.attack(louis);
        Assertions.assertThat(louis.health).isEqualTo(Health.of(900));
    }

    @Test
    public void cannot_be_inflicted_to_character_himself() {
        Character john = new Character();
        john.attack(john);
        Assertions.assertThat(john.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void are_half_reduced_when_target_has_5_more_level_than_attacker() {
        Character john = new Character();
        john.level = Level.of(10);
        Character louis = new Character();
        louis.level = Level.of(15);

        john.attack(louis);
        Assertions.assertThat(louis.health).isEqualTo(Health.of(950));
    }
}
