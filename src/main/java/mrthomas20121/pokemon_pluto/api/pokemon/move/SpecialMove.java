package mrthomas20121.pokemon_pluto.api.pokemon.move;

import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class SpecialMove extends PhysicalMove {

    public SpecialMove(String name, PokemonType type, int pp, int power) {
        super(name, type, pp, power);
    }

    @Override
    public Category getCategory() {
        return Category.SPECIAL;
    }
}
