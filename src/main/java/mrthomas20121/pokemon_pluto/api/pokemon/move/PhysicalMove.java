package mrthomas20121.pokemon_pluto.api.pokemon.move;

import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class PhysicalMove extends Move {

    public PhysicalMove(String name, int pp, int power, PokemonType type) {
        super(name, pp, power, type);
    }

    @Override
    public PokemonType getType() {
        return type;
    }

    @Override
    public Category getCategory() {
        return Category.PHYSICAL;
    }
}
