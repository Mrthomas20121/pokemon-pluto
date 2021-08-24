package mrthomas20121.pokemon_pluto.api.item;

import com.google.gson.JsonObject;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.json.JsonSerializer;

/**
 * @author Mrthomas20121
 * ItemSerializer.java
 * Deserialize a json into an item.
 * Json need to be like this :
 * {
 *     "name":"something",
 *     "category":"pokeball"
 * }
 */
public class ItemSerializer implements JsonSerializer<Item> {

    @Override
    public Item deserialize(JsonObject jsonObject) {
        return new Item(new GameLocation(jsonObject.get("name").getAsString()), jsonObject.get("category").getAsString().toUpperCase());
    }
}
