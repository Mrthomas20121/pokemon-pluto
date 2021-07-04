package mrthomas20121.pokemon_pluto.api.pokemon.type;

import mrthomas20121.pokemon_pluto.api.pokemon.Effectiveness;
import mrthomas20121.pokemon_pluto.api.pokemon.manager.Manager;

public abstract class PokemonType {

    private final String name;

    public PokemonType(String name) {
        this.name = name;

        // register the type
        Manager.registerType(this);
    }

    public String getName() {
        return name;
    }

    public abstract Effectiveness getEffectiveness(PokemonType type);
}
