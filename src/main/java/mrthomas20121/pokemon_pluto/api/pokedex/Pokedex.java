package mrthomas20121.pokemon_pluto.api.pokedex;

import com.google.common.flogger.StackSize;
import com.google.gson.stream.JsonReader;
import mrthomas20121.pokemon_pluto.PokemonPluto;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.json.JsonUtil;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Pokedex {

    private static final List<PokedexEntry> internalPokedex = new LinkedList<>();
    private static final List<GameLocation> locations = new LinkedList<>();

    public static PokedexEntry getEntryByName(String name) {
        return internalPokedex.stream().filter(pokedexEntry -> pokedexEntry != null && pokedexEntry.getRegistryName().toString().equals(name)).findFirst().orElse(null);
    }

    /**
     * Register a Pokédex entry to the Pokédex.
     * @param pokedexEntry the Pokédex entry
     */
    public static void registerEntry(PokedexEntry pokedexEntry) {
        if(locations.contains(pokedexEntry.getRegistryName())) {
            PokemonPluto.getLogger().atWarning().withStackTrace(StackSize.MEDIUM).log("Cannot register %s because an element with the same registry name was registered before", pokedexEntry.getRegistryName().toString());
        }
        else {
            locations.add(pokedexEntry.getRegistryName());
            internalPokedex.add(pokedexEntry);
        }
    }
}
