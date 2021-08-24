package mrthomas20121.pokemon_pluto.api.item;

import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.item.effect.ItemEffect;
import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

public class Item implements IHandlerEntry {

    private final GameLocation name;
    private final ItemCategory category;
    private ItemEffect effect;

    public Item(GameLocation name, String itemCategory) {
        this(name, ItemCategory.valueOf(itemCategory.toUpperCase()));
    }

    public Item(GameLocation name, ItemCategory category) {
        this.name = name;
        this.category = category;
    }

    public Item(GameLocation name) {
        this(name, ItemCategory.ITEM);
    }

    public GameLocation getRegistryName() {
        return name;
    }

    public ItemCategory getCategory() {
        return category;
    }

    @Override
    public GameTranslation getTranslationKey() {
        return new GameTranslation(String.format("item.%s", this.name.getPath()));
    }

    public void setEffect(ItemEffect effect) {
        this.effect = effect;
    }

    public ItemEffect getEffect() {
        return effect;
    }

    public enum ItemCategory {
        ITEM,
        STATUS_AND_HEAL,
        POKEBALL,
        TMS_AND_HMS,
        BERRIES,
        KEY
    }
}
