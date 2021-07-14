package mrthomas20121.pokemon_pluto.api.item;

import mrthomas20121.pokemon_pluto.api.data.SerialData;
import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;

import java.util.List;

public abstract class Item implements SerialData {

    private final String name;

    private ItemCategory category;

    public Item(String name, String itemCategory) {
        this(name, ItemCategory.valueOf(itemCategory.toUpperCase()));
    }

    public Item(String name, ItemCategory category) {
        this.name = name;
        this.category = category;
    }

    public Item(String name) {
        this(name, ItemCategory.ITEM);
    }

    public String getRegistryName() {
        return name;
    }

    public ItemCategory getCategory() {
        return category;
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

    public enum ItemCategory {
        ITEM,
        STATUS_AND_HEAL,
        POKEBALL,
        TMS_AND_HMS,
        BERRIES,
        KEY
    }
}
