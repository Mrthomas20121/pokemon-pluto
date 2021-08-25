package mrthomas20121.pokemon_pluto.api.pokemon;

import com.google.gson.JsonObject;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.json.JsonSerializer;
import mrthomas20121.pokemon_pluto.api.handler.GameManager;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class PokemonSerializer implements JsonSerializer<Pokemon> {

    @Override
    public Pokemon deserialize(JsonObject jsonObject) {
        String pokemon_name = jsonObject.get("name").getAsString();
        String sType1 = jsonObject.get("type1").getAsString();
        String sType2 = jsonObject.has("type2") ? jsonObject.get("type2").getAsString():null;
        PokemonType type1 = GameManager.pokemonTypeHandler.getElementByName(new GameLocation(sType1));
        PokemonType type2 = null;
        if(sType2 != null) {
            type2 = GameManager.pokemonTypeHandler.getElementByName(new GameLocation(sType1));
        }
        return new Pokemon(new GameLocation(pokemon_name), type1, type2);
    }

    @Override
    public JsonObject serialize(Pokemon obj) {
        JsonObject object = new JsonObject();
        object.addProperty("name", obj.getRegistryName().toString());
        object.addProperty("type1", obj.getFirstType().getRegistryName().toString());
        object.addProperty("type2", obj.hasTwoTypes() ? obj.getSecondaryType().getRegistryName().toString() : "");
        return object;
    }
}
