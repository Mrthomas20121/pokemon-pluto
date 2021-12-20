package mrthomas20121.pokemon_pluto.api.recipe.item;

import mrthomas20121.pokemon_pluto.api.PlutoObject;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

public abstract class Item implements PlutoObject<Item> {

    private GameLocation registryName;
    private final IItemCategory category;

    public Item(IItemCategory category) {
        this.category = category;
    }

    @Override
    public Item setRegistryName(GameLocation registryName) {
        this.registryName = registryName;
        return this;
    }

    @Override
    public GameLocation getRegistryName() {
        return this.registryName;
    }

    public IItemCategory getCategory() {
        return category;
    }
}
