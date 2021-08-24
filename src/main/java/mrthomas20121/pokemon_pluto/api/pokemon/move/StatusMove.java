package mrthomas20121.pokemon_pluto.api.pokemon.move;

import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class StatusMove extends Move {

    public StatusMove(String name, PokemonType type) {
        super(name, 0, 0, type);
    }

    @Override
    public PokemonType getType() {
        return this.type;
    }

    @Override
    public Category getCategory() {
        return Category.STATUS;
    }
}
