package mrthomas20121.pokemon_pluto.api.pokemon.helpers;

import mrthomas20121.pokemon_pluto.api.pokemon.Pokemon;
import mrthomas20121.pokemon_pluto.api.pokemon.move.Move;


public class DamageHelper {

    public static double getDamageFormula(Pokemon pkmn, Pokemon target, Move move) {
        double size = 1;
        double pokemon_attack = 1; // pokemon attack
        double target_defence = 1; // target defence
        double weather = 1;
        double critical_hit = 1; // 1.5 if critical hit
        double random = 1; // random number between 0.85 and 1.00(inclusive)
        double type_effectiveness = PokemonHelper.getEffectiveness(move.getType(), target).getMultiplicator(); // Effectiveness based on the move and the target type
        double burn = 0.5; // 0.5 if target is burned and ability is not guts and a physical move was used. otherwise 1.
        double item_effect = 1; // item effect

        return ( ((2*pkmn.getLevel())*(move.getPower()*pokemon_attack/target_defence)/50+2) * size * weather * critical_hit * random * type_effectiveness * burn * item_effect);
    }
}
