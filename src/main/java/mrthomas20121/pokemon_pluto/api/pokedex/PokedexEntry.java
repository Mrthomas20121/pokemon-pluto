package mrthomas20121.pokemon_pluto.api.pokedex;

import mrthomas20121.pokemon_pluto.api.Translation;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;

public class PokedexEntry implements IPokedex, IHandlerEntry {

    private final GameLocation name;
    private final String description;

    public PokedexEntry(final GameLocation name, final String description) {
        this.name = name;
        this.description = description;
    }

    public PokedexEntry(final String name, final String description) {
        this(new GameLocation("pokemon_pluto", name), description);
    }

    @Override
    public GameLocation getName() {
        return name;
    }

    @Override
    public GameLocation getRegistryName() {
        return this.getName();
    }

    @Override
    public GameTranslation getTranslationKey() {
        return new GameTranslation(String.format("pokedex.%s.description", this.name.getPath()));
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTranslatedDescription() {
        return Translation.translate(String.format("pokedex.%s.description", this.name));
    }

    @Override
    public String getTranslatedName() {
        return Translation.translate(String.format("pokedex.%s.name", this.name));
    }
}
