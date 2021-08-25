package mrthomas20121.pokemon_pluto.api.handler;

import com.google.common.flogger.StackSize;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import mrthomas20121.pokemon_pluto.PokemonPluto;
import mrthomas20121.pokemon_pluto.api.json.JsonSerializer;
import mrthomas20121.pokemon_pluto.api.json.JsonUtil;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

import java.util.LinkedList;

public class AbstractHandler<T extends IHandlerEntry> {
    private final GameLocation name;
    protected final LinkedList<T> internalList = new LinkedList<>();
    protected final LinkedList<GameLocation> locations = new LinkedList<>();
    private final JsonSerializer<T> serializer;

    public AbstractHandler(GameLocation location, JsonSerializer<T> serializer) {
        this.name = location;
        this.serializer = serializer;
    }

    public AbstractHandler(String name) {
        this(name, null);
    }

    public AbstractHandler(String name, JsonSerializer<T> serializer) {
        this(new GameLocation(name), serializer);
    }

    public JsonSerializer<T> getJsonSerializer() {
        return serializer;
    }

    public boolean register(T element) {
        if(locations.contains(element.getRegistryName())) {
            PokemonPluto.getLogger().atWarning().withStackTrace(StackSize.LARGE).log("Cannot register %s because an element with the same registry name was registered before", element.getRegistryName().toString());
            return false;
        }

        // add the registry name to the registry name list.
        this.locations.add(element.getRegistryName());
        return this.internalList.add(element);
    }

    public int size() {
        return this.internalList.size();
    }

    public boolean isEmpty() {
        return this.internalList.isEmpty();
    }

    public void registerFromJsonList(String file) {
        JsonArray array = JsonUtil.getResourceFromJson(file, JsonArray.class);
        this.serializer.deserialize(array).forEach(this::register);
    }

    public void registerFromJson(String file) {
        JsonObject jsonObject = JsonUtil.getResourceFromJson(file, JsonObject.class);
        T object = this.serializer.deserialize(jsonObject);
        register(object);
    }

    /**
     * Get an Element by name.
     * Override this if you wish to return a default value if the name doesn't exists. by default it return null.
     * @param name name
     * @return The Element with said name.
     */
    public T getElementByName(GameLocation name) {
        return this.internalList.stream().filter(t -> t.getRegistryName().equals(name)).findFirst().orElse(null);
    }

    public T getElement(int index) {
        return this.internalList.get(index);
    }

    public LinkedList<T> getList() {
        return internalList;
    }

    public GameLocation getRegistryName() {
        return this.name;
    }
}
