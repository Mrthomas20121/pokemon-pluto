package mrthomas20121.pokemon_pluto.api.pokemon.move;

import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public abstract class NonObtainableMove extends Move {

    private final int nb;

    public NonObtainableMove(int nb, final String name, int pp, int power, PokemonType type) {
        super(name, pp, power, type);
        this.nb = nb;
    }

    public int getNumber() {
        return this.nb;
    }
}
