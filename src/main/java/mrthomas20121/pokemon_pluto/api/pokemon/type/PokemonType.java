package mrthomas20121.pokemon_pluto.api.pokemon.type;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;
import mrthomas20121.pokemon_pluto.api.handler.GameManager;

/**
 * PokemonType.java - Mrthomas20121 2021
 * Implementation of a Pokemon Type.
 */
public class PokemonType implements IHandlerEntry {

    private final GameLocation name;

    public PokemonType(String name) {
        this(name, false);
    }

    public PokemonType(String name, boolean shouldRegisterOnCreation) {
        this.name = new GameLocation(name);

        // register the type on creation
        if(shouldRegisterOnCreation) GameManager.pokemonTypeHandler.register(this);
    }

    public GameLocation getRegistryName() {
        return name;
    }

    @Override
    public GameTranslation getTranslationKey() {
        return new GameTranslation(String.format("type.%s", this.name.getPath()));
    }
}
