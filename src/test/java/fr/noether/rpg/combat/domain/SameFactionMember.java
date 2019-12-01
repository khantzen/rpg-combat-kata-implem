package fr.noether.rpg.combat.domain;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

public class SameFactionMember {

    @Test
    @Ignore
    public void should_not_be_able_to_inflict_damage_to_each_others() {
        Fighter john = new Fighter(Distance.of(2));
        Fighter louis = new Fighter(Distance.of(2));
        john.attack(louis);
        Assertions.assertThat(louis.health).isEqualTo(Health.of(1000));
    }
}
