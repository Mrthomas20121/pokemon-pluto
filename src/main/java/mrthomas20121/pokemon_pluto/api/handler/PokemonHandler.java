package mrthomas20121.pokemon_pluto.api.handler;

import mrthomas20121.pokemon_pluto.api.pokemon.Pokemon;
import mrthomas20121.pokemon_pluto.api.pokemon.PokemonSerializer;

public class PokemonHandler extends AbstractHandler<Pokemon> {

    public PokemonHandler() {
        super("pluto:pokemon", new PokemonSerializer());
    }
}
