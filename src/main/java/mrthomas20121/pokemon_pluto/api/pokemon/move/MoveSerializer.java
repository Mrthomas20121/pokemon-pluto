package mrthomas20121.pokemon_pluto.api.pokemon.move;

import com.google.gson.JsonObject;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.json.JsonSerializer;
import mrthomas20121.pokemon_pluto.api.handler.GameManager;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class MoveSerializer implements JsonSerializer<Move> {

    @Override
    public Move deserialize(JsonObject jsonObject) {
        String type = jsonObject.get("type").getAsString();
        String name = jsonObject.get("name").getAsString();
        int pp = jsonObject.get("pp").getAsInt();
        int power = jsonObject.get("power").getAsInt();
        String pokemonTypeS = jsonObject.get("pokemon_type").getAsString();
        PokemonType pokemonType = GameManager.pokemonTypeHandler.getElementByName(new GameLocation(pokemonTypeS));
        if(type.equals("physical")) {
            return new PhysicalMove(name, pp, power, pokemonType);
        }
        else if(type.equals("special")) {
            return new SpecialMove(name, pp, power, pokemonType);
        }
        else if(type.equals("status")) {
            return new StatusMove(name, pokemonType);
        }
        return new Move(name, pokemonType) {

            @Override
            public Category getCategory() {
                return null;
            }
        };
    }

    @Override
    public JsonObject serialize(Move obj) {
        JsonObject object = new JsonObject();
        object.addProperty("type", getType(obj));
        return object;
    }

    private String getType(Move obj) {
        String str = "";
        if(obj instanceof SpecialMove) {
            str = "special";
        }
        else if(obj instanceof PhysicalMove) {
            str = "physical";
        }
        else if(obj instanceof StatusMove) {
            str = "status";
        }
        return str;
    }
}
