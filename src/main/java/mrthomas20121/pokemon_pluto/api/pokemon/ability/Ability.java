package mrthomas20121.pokemon_pluto.api.pokemon.ability;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;

public abstract class Ability implements IHandlerEntry {

    private final GameLocation registryName;

    public Ability(GameLocation name) {
        this.registryName = name;
    }

    public Ability(String name) {
        this(new GameLocation(name));
    }

    @Override
    public GameTranslation getTranslationKey() {
        return new GameTranslation(String.format("ability.%s", this.registryName.getPath()));
    }

    @Override
    public GameLocation getRegistryName() {
        return registryName;
    }
}
