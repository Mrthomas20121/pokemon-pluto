package mrthomas20121.pokemon_pluto.api.pokemon.helpers;

import mrthomas20121.pokemon_pluto.api.pokemon.Effectiveness;
import mrthomas20121.pokemon_pluto.api.pokemon.Pokemon;
import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class PokemonHelper {

    public static Effectiveness getEffectiveness(PokemonType type, PokemonData target) {
        if(target.get().hasTwoTypes()) {
//            if(target.getFirstType().getEffectiveness(type).equals(target.getSecondaryType().getEffectiveness(type))) {
//                return target.getFirstType().getEffectiveness(type);
//            }
        }
        return Effectiveness.EFFECTIVE;
    }
}
