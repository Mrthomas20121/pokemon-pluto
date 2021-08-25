package mrthomas20121.pokemon_pluto.api.pokemon.type;

import com.google.gson.JsonObject;
import mrthomas20121.pokemon_pluto.api.json.JsonSerializer;

public class PokemonTypeSerializer implements JsonSerializer<PokemonType> {

    @Override
    public PokemonType deserialize(JsonObject jsonObject) {
        String type = jsonObject.get("name").getAsString();
        return new PokemonType(type, false);
    }
}
