package fr.noether.rpg.combat.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FighterDamage {

    @Test
    public void can_be_inflicted_to_another_character() {
        Fighter john = new Fighter(Distance.of(2), Factions.of("Unit"));
        Fighter louis = new Fighter(Distance.of(2), Factions.of("Test"));
        john.attack(louis);
        Assertions.assertThat(louis.health).isEqualTo(Health.of(900));
    }

    @Test
    public void cannot_be_inflicted_to_character_himself() {
        Fighter john = new Fighter(Distance.of(2), Factions.of("Unit"));
        john.attack(john);
        Assertions.assertThat(john.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void are_half_reduced_when_target_has_5_or_more_level_than_attacker() {
        Fighter john = new Fighter(Distance.of(2), Factions.of("Unit"));
        john.level = Level.of(10);
        Fighter louis = new Fighter(Distance.of(2), Factions.of("Test"));
        louis.level = Level.of(15);

        john.attack(louis);
        Assertions.assertThat(louis.health).isEqualTo(Health.of(950));
    }

    @Test
    public void are_doubled_when_target_has_5_or_less_level_than_attacker() {
        Fighter john = new Fighter(Distance.of(2), Factions.of("Unit"));
        john.level = Level.of(15);
        Fighter louis = new Fighter(Distance.of(2), Factions.of("Test"));
        louis.level = Level.of(9);

        john.attack(louis);
        Assertions.assertThat(louis.health).isEqualTo(Health.of(800));
    }
}
