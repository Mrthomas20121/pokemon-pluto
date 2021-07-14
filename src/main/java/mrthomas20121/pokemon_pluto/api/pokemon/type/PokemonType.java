package mrthomas20121.pokemon_pluto.api.pokemon.type;

import mrthomas20121.pokemon_pluto.api.data.SerialData;
import mrthomas20121.pokemon_pluto.api.pokemon.Effectiveness;
import mrthomas20121.pokemon_pluto.api.manager.TempManager;

/**
 * PokemonType.java - Mrthomas20121 2021
 * Implementation of a Pokemon Type.
 */
public abstract class PokemonType implements SerialData {

    private final String name;

    public PokemonType(String name) {
        this.name = name;

        // register the type
        TempManager.registerType(this);
    }

    public String getRegistryName() {
        return name;
    }

    /**
     * Get the Effectiveness against another type.
     * @param type another type
     * @return Return the Effectiveness against that type.
     */
    public abstract Effectiveness getEffectiveness(PokemonType type);

    /**
     *Get the Effectiveness against two type for pokemon with 2 types.
     * @param type another type
     * @param type2 another type
     * @return The Effectiveness of that type against the two types.
     */
    public Effectiveness getEffectiveness(PokemonType type, PokemonType type2) {
        Effectiveness effectiveness1 = this.getEffectiveness(type);
        Effectiveness effectiveness2 = this.getEffectiveness(type2);
        if(effectiveness1.equals(effectiveness2)) {
            // if they are both super effective, make it double effective.
            if(effectiveness1.equals(Effectiveness.SUPER_EFFECTIVE) && effectiveness2.equals(Effectiveness.SUPER_EFFECTIVE)) {
                return Effectiveness.DOUBLE_EFFECTIVE;
            }
            return effectiveness1;
        }
        else if(effectiveness1.equals(Effectiveness.NO_EFFECT) || effectiveness2.equals(Effectiveness.NO_EFFECT)) {
            // No Effect is like combat attack on ghost attack, they don't work.
            return Effectiveness.NO_EFFECT;
        }
        return Effectiveness.EFFECTIVE;
    }
}
