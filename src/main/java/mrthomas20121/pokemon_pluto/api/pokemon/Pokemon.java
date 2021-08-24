package mrthomas20121.pokemon_pluto.api.pokemon;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class Pokemon implements IHandlerEntry {

    private final GameLocation name;

    private final PokemonType first_type;
    private final PokemonType second_type;

    private EvolutionTree evolution;

    public Pokemon(GameLocation name, PokemonType type1, PokemonType type2) {
        this.name = name;
        this.first_type = type1;
        this.second_type = type2;
        this.evolution = new EvolutionTree(name.toString());
    }

    public GameLocation getRegistryName() {
        return name;
    }

    public PokemonType getFirstType() {
        return first_type;
    }
    
    public PokemonType getSecondaryType() {
        return this.second_type;
    }

    public boolean hasTwoTypes() {
        return this.second_type != null;
    }

    public void setEvolution(EvolutionTree evolution) {
        this.evolution = evolution;
    }

    public EvolutionTree getEvolutionTree() {
        return evolution;
    }

    public boolean canEvolve() {
        return this.evolution.getEvolution2()!=null;
    }

    @Override
    public GameTranslation getTranslationKey() {
        return new GameTranslation(String.format("pokemon.%s.name", this.name.getPath()));
    }
}
