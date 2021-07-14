package mrthomas20121.pokemon_pluto.api.manager;

import mrthomas20121.pokemon_pluto.api.item.Item;
import mrthomas20121.pokemon_pluto.api.item.ItemKey;
import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;

import java.util.List;

public class ItemManager extends Manager<Item> {

    Item defaultItem = new Item("default") {
        @Override
        public void onPokemonUse(PokemonData pokemon) {

        }

        @Override
        public void onUse(List<PokemonData> pokemonList) {

        }

        @Override
        public void afterDamage(PokemonData pokemon) {

        }

        @Override
        public void afterHeal(PokemonData pokemon) {

        }

        @Override
        public void onTurnStart(PokemonData pokemon) {

        }

        @Override
        public void onTurnEnd(PokemonData pokemon) {

        }
    };

    public List<Item> getKeyItems() {
        return this.value.stream().filter(item -> item instanceof ItemKey || item.getCategory().equals(Item.ItemCategory.KEY)).toList();
    }

    /**
     * Get an Element by name.
     * @param name name
     * @return The Element with said name.
     */
    @Override
    public Item getElementByName(String name) {
        return this.value.stream().filter(t -> t.getRegistryName().equals(name)).findFirst().orElse(defaultItem);
    }
}
