package mrthomas20121.pokemon_pluto.api.pokemon;

import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class Pokemon {

    private final String name;

    private final PokemonType first_type;
    private final PokemonType second_type;

    public Pokemon(String name, PokemonType type1, PokemonType type2) {
        this.name = name;
        this.first_type = type1;
        this.second_type = type2;
    }

    public String getName() {
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
}
