package mrthomas20121.pokemon_pluto.api.pokemon.pokedex;

import mrthomas20121.pokemon_pluto.api.Translation;

public class PokedexEntry implements IPokedex {

    private String name;
    private String description;

    public PokedexEntry(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
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
