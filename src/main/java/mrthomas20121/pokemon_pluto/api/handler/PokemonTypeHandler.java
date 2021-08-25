package mrthomas20121.pokemon_pluto.api.handler;

import mrthomas20121.pokemon_pluto.api.pokemon.type.*;

public class PokemonTypeHandler extends AbstractHandler<PokemonType> {

    public PokemonTypeHandler() {
        super("pluto:pokemon_type", new PokemonTypeSerializer());
    }
}
