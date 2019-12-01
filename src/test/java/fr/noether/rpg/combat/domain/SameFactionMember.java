package fr.noether.rpg.combat.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SameFactionMember {

    @Test
    public void should_not_be_able_to_inflict_damage_to_each_others() {
        Fighter john = new Melee();
        Fighter louis = new Melee();

        john.join(Faction.of("Unit"));
        louis.join(Faction.of("Unit"));

        john.attack(louis);

        assertThat(louis.health).isEqualTo(Health.of(1000));
    }

    @Test
    public void should_be_able_to_heal_each_other() {
        Fighter john = new Melee();
        Fighter louis = new Melee();

        louis.takeDamage(Damage.of(300));

        john.join(Faction.of("Unit"));
        louis.join(Faction.of("Unit"));

        john.heal(louis);

        assertThat(louis.health).isEqualTo(Health.of(800));
    }
}
