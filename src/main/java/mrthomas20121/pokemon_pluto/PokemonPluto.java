package mrthomas20121.pokemon_pluto;

import com.google.common.flogger.FluentLogger;
import com.google.gson.JsonObject;
import mrthomas20121.pokemon_pluto.api.json.JsonUtil;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonTypeSerializer;

public class PokemonPluto {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static FluentLogger getLogger() {
        return logger;
    }

    public static void main(String[] args) {
        PokemonTypeSerializer serializer = new PokemonTypeSerializer();
        JsonObject object = JsonUtil.getResourceFromJson("pokemon/test.json", JsonObject.class);
        logger.atInfo().log(serializer.deserialize(object).getRegistryName().toString());
    }
}
