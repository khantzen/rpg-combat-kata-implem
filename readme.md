# RPG Combat Kata

## Domain

For the scope of this kata, the player won't be running around and doing stuff. The features implemented in each iteration will be limited to the framework that the game may use in the future.

It is centered on the characters combat skills which are basically damaging and healing.

## Iteration 1 

#### Characters...

- have Health, starting at 1000.
- have Level, starting at 1.
- are dead or alive.
- can deal damage.
- can heal.

#### Conditions

 - When the damage received is higher than the actual health, health drops to 0 and the character dies.
 - When the character is dead, he cannot be healed.
 - The character cannot be healed over 1000 health.

## Iteration 2

The player can deal damage to his enemies, but not to himself.
The player can heal himself, but not his enemies.
The level now has an effect on the damage applied : 
   - If the target is 5 or more levels above the player, the damage applied will be reduced by 50%
   - If the target is 5 or more levels below the player, the damage applied will be boosted by 50%

## Iteration 3
 
The player has an attack range.
   - If he is a melee fighter, his range will be 2 meters.
   - If he is a ranged fighter, his range will be 20 meters.
   - When trying to deal damage, the player must be in range.

## Retrospective

- Are you keeping up with the requirements ?
- Do you feel good about your design, is it scalable and easily adapted to the new requirements that will be introduced in the last iterations ? 
- Is everything tested and are you confient in your tests ? 

## Iteration 4

We now have factions.
 - One player may join or leave one or more factions.
 - Players of the same faction are allies :
   - They can't damage each other.
   - They can heal each other.

## Iteration 5

Finally, the player can damage other things that are not characters (props). This means that he can attack a house, a tree or anything else that has some health.
 - Those things cannot heal nor be healed and cannot deal damage.
 - They belong to no faction, as they are neutral things.
 - You may setup a house starting with 2000 health.

## Final Retrospective

 - What problems did you encounter ? 
 - What have you learned ? 
 - Debate on the different ways to possibly solve the kata!


# Note for Facilitators : 

 - You may fix a time limit for each iteration as a constraint.
 - 10min preparation for finding a pair, choosing a langage & setting up the environment.
 - 10min retrospective before iteration 4.
 - Open the debate on final retrospective on the diffrent ways to possibly solve the kata.

*Source http://www.slideshare.net/DanielOjedaLoisel/rpg-combat-kata*
