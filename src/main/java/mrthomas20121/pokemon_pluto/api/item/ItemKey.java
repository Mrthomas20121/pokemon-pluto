package mrthomas20121.pokemon_pluto.api.item;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

/**
 * ItemKey.java
 * @author mrthomas20121
 * Implementation of the Key Items
 */
public class ItemKey extends Item {

    public ItemKey(GameLocation name) {
        super(name, ItemCategory.KEY);
    }

    public ItemKey(GameLocation name, ItemCategory category) {
        super(name, category);
    }

    /**
     * Check Whether Pokemons can hold this item or not.
     * @return true if the item can be hold
     */
    public boolean canBeHold() {
        return true;
    }
}
