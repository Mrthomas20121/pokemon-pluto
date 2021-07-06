package mrthomas20121.pokemon_pluto.api.item;

import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;

import java.util.List;

public abstract class Item {

    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * This get called when you use a item on a pokemon(inside and outside a battle)
     * @param pokemon The affected pokemon.
     */
    public abstract void onPokemonUse(PokemonData pokemon);

    /**
     * This get called when you use an item before
     * @param pokemonList The list of pokemon in your inventory.
     */
    public abstract void onUse(List<PokemonData> pokemonList /* todo let them see the current open inventory*/);

    /**
     * This get called right after the pokemon has taken damage
     * @param pokemon The affected pokemon.
     */
    public abstract void afterDamage(PokemonData pokemon);

    /**
     * This get called right after the pokemon is healed.
     * @param pokemon The affected pokemon
     */
    public abstract void afterHeal(PokemonData pokemon);

    /**
     * This get called when a character turn start.
     * @param pokemon The affected pokemon
     */
    public abstract void onTurnStart(PokemonData pokemon);

    /**
     * This get called when a character turn end. Useful for implementing stuff like Leftover
     * @param pokemon The affected pokemon
     */
    public abstract void onTurnEnd(PokemonData pokemon);
}
