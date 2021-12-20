package mrthomas20121.pokemon_pluto;

import com.google.common.flogger.FluentLogger;
import mrthomas20121.pokemon_pluto.api.handler.GameManager;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

public class PokemonPluto {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static FluentLogger getLogger() {
        return logger;
    }

    public static void main(String[] args) {
        GameManager.pokemonTypeHandler.registerFromJson("assets/pokemon/test.json");
        //getLogger().atInfo().log(GameManager.pokemonTypeHandler.getElementByName(new GameLocation("pluto:psy")).getRegistryName().toString());
    }
}
