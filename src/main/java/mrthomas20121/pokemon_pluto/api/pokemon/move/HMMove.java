package mrthomas20121.pokemon_pluto.api.pokemon.move;

import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

/**
 * @author Mrthomas20121
 *  Move that can be taught
 */
public abstract class HMMove extends NonObtainableMove {

    public HMMove(int nb, final String name, int pp, int power, PokemonType type) {
        super(nb, name, pp, power, type);
    }

    @Override
    public abstract Category getCategory();
}
