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
}
