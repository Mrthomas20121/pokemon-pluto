package mrthomas20121.pokemon_pluto.api.pokedex;

import com.google.gson.stream.JsonReader;
import mrthomas20121.pokemon_pluto.api.json.JsonUtil;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Pokedex {

    private static List<PokedexEntry> pokedex = new LinkedList<>();

    public static PokedexEntry getEntryByName(String name) {
        return pokedex.stream().filter(pokedexEntry -> pokedexEntry != null && pokedexEntry.getName().equals(name)).findFirst().get();
    }

    /**
     * Register a pokedex entry to the pokedex.
     * @param pokedexEntry the pokedex entry
     */
    public static void registerEntry(PokedexEntry pokedexEntry) {
        if(!pokedex.contains(pokedexEntry)) {
            pokedex.add(pokedexEntry);
        }
    }

    /**
     * Register a Pokedex Entry from a json file
     * @param file file path
     */
    public static void registerEntryFromJson(String file) {
        InputStream input = PokedexEntry.class.getClassLoader().getResourceAsStream(file);
        JsonReader reader = new JsonReader(new InputStreamReader(input));
        PokedexEntry entry = JsonUtil.gson.fromJson(reader, PokedexEntry.class);
        registerEntry(entry);
    }

    /**
     * Create the pokedex from JSON
     * @param file json file
     */
    public static void createPokedexFromJson(String file) {
        InputStream input = PokedexEntry.class.getClassLoader().getResourceAsStream(file);
        JsonReader reader = new JsonReader(new InputStreamReader(input));
        PokedexEntry[] entries = JsonUtil.gson.fromJson(reader, PokedexEntry[].class);
        for(PokedexEntry entry: entries) {
            registerEntry(entry);
        }
    }
}
