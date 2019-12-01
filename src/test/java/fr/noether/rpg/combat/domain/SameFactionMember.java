package fr.noether.rpg.combat.domain;

import org.junit.Test;

public class SameFactionMember {

    @Test
    public void should_not_be_able_to_inflict_damage_to_each_others() {
        Fighter john = new Fighter(Distance.of(3), Factions.of("Unit"));
        Fighter louis = new Fighter(Distance.of(3), Factions.of("Unit"));
    }
}
