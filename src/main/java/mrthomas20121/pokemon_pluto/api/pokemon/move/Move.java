package mrthomas20121.pokemon_pluto.api.pokemon.move;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public abstract class Move implements IHandlerEntry {

    private final GameLocation name;

    protected int pp;
    protected int max_pp;
    protected int power;
    protected PokemonType type;

    public Move(final String name, int pp, int power, PokemonType type) {
        this.name = new GameLocation(name);
        this.pp = pp;
        this.max_pp = pp;
        this.power = power;
        this.type = type;
    }

    public Move(final String name, int power, PokemonType type) {
        this(name, 40, power, type);
    }

    public Move(final String name, PokemonType type) {
        this(name,0, type);
    }

    /***
     * Use the Move.
     * @return true if pp were reduced. false otherwise
     */
    public boolean use() {
        if(pp > 0) {
            this.pp--;
            return true;
        }
        return false;
    }

    public GameLocation getRegistryName() {
        return name;
    }

    @Override
    public GameTranslation getTranslationKey() {
        return new GameTranslation(String.format("move.%s", this.name.getPath()));
    }

    public int getMaxPP() {
        return max_pp;
    }

    public int getPP() {
        return pp;
    }

    public int getPower() {
        return power;
    }

    public PokemonType getType() {
        return this.type;
    }

    public abstract Category getCategory();
}
