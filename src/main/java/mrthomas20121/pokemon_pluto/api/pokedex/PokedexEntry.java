package mrthomas20121.pokemon_pluto.api.pokedex;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;

public abstract class PokedexEntry implements IHandlerEntry, IPokedexEntry {

    private final GameLocation name;
    protected final String text;

    public PokedexEntry(final GameLocation name, final String text) {
        this.name = name;
        this.text = text;
    }

    public PokedexEntry(final String name, final String text) {
        this(new GameLocation("pluto", name), text);
    }

    @Override
    public GameLocation getRegistryName() {
        return this.name;
    }

    @Override
    public GameTranslation getTranslationKey() {
        return new GameTranslation(this.getText());
    }
}
