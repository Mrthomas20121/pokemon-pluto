package mrthomas20121.pokemon_pluto.api.handler;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.item.Item;
import mrthomas20121.pokemon_pluto.api.item.ItemSerializer;

import java.util.List;

public final class ItemHandler extends AbstractHandler<Item> {

    Item defaultItem = new Item(new GameLocation("pluto:default"));
    
    public ItemHandler() {
        super("pluto:item", new ItemSerializer());

        // set the default entry for the item in case no item can be found
        this.setDefaultEntry(defaultItem);
    }

    @Override
    public boolean register(Item element) {
        return super.register(element);
    }

    public List<Item> getKeyItems() {
        return this.internalHashSet.stream().filter(item -> item.getCategory().equals(Item.ItemCategory.KEY)).toList();
    }
}
