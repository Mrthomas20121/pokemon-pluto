package mrthomas20121.pokemon_pluto.api.pokemon.move;

import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class SpecialMove extends PhysicalMove {

    public SpecialMove(String name, int pp, int power, PokemonType type) {
        super(name, pp, power, type);
    }

    @Override
    public Category getCategory() {
        return Category.SPECIAL;
    }
}
