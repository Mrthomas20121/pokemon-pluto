package mrthomas20121.pokemon_pluto.api.item.effect;

import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;

import java.util.List;

public interface ItemEffect {

    /**
     * This get called when you use a item on a pokemon(inside and outside a battle)
     * @param pokemon The affected pokemon.
     */
    void onPokemonUse(PokemonData pokemon);

    /**
     * This get called when you use an item.
     * @param pokemonList The list of pokemon in your inventory.
     */
    void beforeItemUse(List<PokemonData> pokemonList /* todo add the player object and the bag object*/);

    /**
     * This get called right after the pokemon has taken damage
     * @param pokemon The affected pokemon.
     */
    void afterDamage(PokemonData pokemon);

    /**
     * This get called right after the pokemon is healed.
     * @param pokemon The affected pokemon
     */
    void afterHeal(PokemonData pokemon);

    /**
     * This get called when a character turn start.
     * @param pokemon The affected pokemon
     */
    void onTurnStart(PokemonData pokemon);

    /**
     * This get called when a character turn end. Useful for implementing stuff like Leftover
     * @param pokemon The affected pokemon
     */
    void onTurnEnd(PokemonData pokemon);

    /**
     * This get called when a pokemon is about to evolve
     * @param pokemon The affected pokemon
     */
    void onPokemonEvolve(PokemonData pokemon);
}
