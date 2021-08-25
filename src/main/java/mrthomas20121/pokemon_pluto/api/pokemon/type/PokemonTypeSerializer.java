package mrthomas20121.pokemon_pluto.api.pokemon.type;

import com.google.gson.JsonObject;
import mrthomas20121.pokemon_pluto.api.json.JsonSerializer;

public class PokemonTypeSerializer implements JsonSerializer<PokemonType> {

    @Override
    public PokemonType deserialize(JsonObject jsonObject) {
        String type = jsonObject.get("name").getAsString();
        boolean shouldRegisterOnLoad = false;
        if(jsonObject.has("shouldRegisterOnLoad")) {
            shouldRegisterOnLoad = jsonObject.get("shouldRegisterOnLoad").getAsBoolean();
        }
        return new PokemonType(type, shouldRegisterOnLoad);
    }

    @Override
    public JsonObject serialize(PokemonType obj) {
        JsonObject object = new JsonObject();
        object.addProperty("name", obj.getRegistryName().toString());
        object.addProperty("shouldRegisterOnLoad", false);
        return object;
    }
}
