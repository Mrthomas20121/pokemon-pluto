package mrthomas20121.pokemon_pluto.api.recipe.item;

import com.google.gson.*;
import mrthomas20121.pokemon_pluto.api.JsonInterface;

import java.lang.reflect.Type;

public class ItemInterface implements JsonInterface<Item> {
    @Override
    public Item deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        String cat = object.get("category").getAsString();
        return new Item(new ItemCategory(cat)) {};
    }

    @Override
    public JsonElement serialize(Item src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("name", src.getRegistryName().toString());
        object.addProperty("category", src.getCategory().getID());
        return object;
    }
}
