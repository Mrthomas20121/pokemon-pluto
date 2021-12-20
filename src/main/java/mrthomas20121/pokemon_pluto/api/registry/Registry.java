package mrthomas20121.pokemon_pluto.api.registry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mrthomas20121.pokemon_pluto.PokemonPluto;
import mrthomas20121.pokemon_pluto.api.JsonInterface;
import mrthomas20121.pokemon_pluto.api.PlutoObject;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Registry<T extends PlutoObject<T>> {
    private final Class<T> internalClass;
    private final Map<GameLocation, T> internal = new HashMap<>();

    private final GsonBuilder builder = new GsonBuilder().serializeNulls();

    public Registry(Class<T> internalClass) {
        this.internalClass = internalClass;
    }

    public void addSerializer(JsonInterface<T> jsonInterface, Type type) {
        builder.registerTypeAdapter(type, jsonInterface);
    }

    public void addSerializer(JsonInterface<T> jsonInterface, Class<T> type) {
        builder.registerTypeAdapter(type, jsonInterface);
    }

    public void addSerializer(JsonInterface<T> jsonInterface) {
        builder.registerTypeAdapter(internalClass, jsonInterface);
    }

    private Gson create() {
        return this.builder.create();
    }

    public void add(T element) {
        GameLocation registryName = element.getRegistryName();
        if(!internal.containsKey(registryName)) {
            internal.put(registryName, element);
        }
        else {
            PokemonPluto.getLogger().atWarning().log(String.format("An object with %s registry name was already registered before!", registryName.toString()));
        }
    }

    public void remove(GameLocation location) {
        internal.remove(location);
    }
}
