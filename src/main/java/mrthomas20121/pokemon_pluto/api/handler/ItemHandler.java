package mrthomas20121.pokemon_pluto.api.handler;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.item.Item;
import mrthomas20121.pokemon_pluto.api.item.ItemKey;
import mrthomas20121.pokemon_pluto.api.item.ItemSerializer;

import java.util.List;

public class ItemHandler extends AbstractHandler<Item> {

    Item defaultItem = new Item(new GameLocation("pluto:default"));
    
    public ItemHandler() {
        super("pluto:item", new ItemSerializer());
    }

    @Override
    public boolean register(Item element) {
        return super.register(element);
    }

    public List<Item> getKeyItems() {
        return this.internalList.stream().filter(item -> item instanceof ItemKey || item.getCategory().equals(Item.ItemCategory.KEY)).toList();
    }

    /**
     * Get an Element by name.
     * @param name name
     * @return The Element with said name.
     */
    @Override
    public Item getElementByName(GameLocation name) {
        return this.internalList.stream().filter(t -> t.getRegistryName().equals(name)).findFirst().orElse(defaultItem);
    }
}
