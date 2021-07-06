package mrthomas20121.pokemon_pluto.api.pokemon;

import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class Pokemon {

    private final String name;

    private final PokemonType first_type;
    private final PokemonType second_type;

    private int starting_level;
    private int level;

    private Object helditem;

    public Pokemon(String name, int starting_level, PokemonType type1, PokemonType type2) {
        this.name = name;
        this.level = starting_level;
        this.starting_level = starting_level;
        this.first_type = type1;
        this.second_type = type2;
    }

    public String getName() {
        return name;
    }

    public void setHeldItem(Object helditem) {
        this.helditem = helditem;
    }

    public void removeHeldItem() {
        this.helditem = null;
    }

    public Object getHeldItem() {
        return helditem;
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

    public void levelup() {
        this.level++;
    }

    public int getStartingLevel() {
        return starting_level;
    }

    public int getLevel() {
        return level;
    }
}
