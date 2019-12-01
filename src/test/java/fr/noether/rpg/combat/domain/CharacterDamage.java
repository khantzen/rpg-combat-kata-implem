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
}
