package mrthomas20121.pokemon_pluto.api.pokemon.move;

import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public abstract class CSMove extends NonObtainableMove {

    public CSMove(int nb, final String name, int pp, int power, PokemonType type) {
        super(nb, name, pp, power, type);
    }

    @Override
    public abstract Category getCategory();
}
