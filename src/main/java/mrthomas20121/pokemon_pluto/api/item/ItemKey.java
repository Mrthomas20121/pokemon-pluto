package mrthomas20121.pokemon_pluto.api.item;

/**
 * Implementation of the Key Items
 */
public abstract class ItemKey extends Item {

    public ItemKey(String name) {
        super(name, ItemCategory.KEY);
    }

    public ItemKey(String name, ItemCategory category) {
        super(name, category);
    }

    public abstract void onKeyItemUse(/* todo give access to the current tile you're looking at*/);

    /**
     * Check Whether pokemon can hold the item or not.
     * @return true if the key item can be hold
     */
    public abstract boolean canBeHold();
}
