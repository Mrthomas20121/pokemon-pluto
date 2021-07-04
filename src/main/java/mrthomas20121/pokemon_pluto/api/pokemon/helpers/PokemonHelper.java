package mrthomas20121.pokemon_pluto.api.pokemon.helpers;

import mrthomas20121.pokemon_pluto.api.pokemon.Effectiveness;
import mrthomas20121.pokemon_pluto.api.pokemon.Pokemon;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class PokemonHelper {

    public static Effectiveness getEffectiveness(PokemonType type, Pokemon target) {
        if(target.hasTwoTypes()) {
            if(target.getFirstType().getEffectiveness(type).equals(target.getSecondaryType().getEffectiveness(type))) {
                return target.getFirstType().getEffectiveness(type);
            }
        }
        return Effectiveness.EFFECTIVE;
    }
}
