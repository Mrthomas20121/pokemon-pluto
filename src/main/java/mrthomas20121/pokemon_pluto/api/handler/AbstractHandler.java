package mrthomas20121.pokemon_pluto.api.handler;

import com.google.common.flogger.StackSize;
import com.google.gson.JsonArray;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import mrthomas20121.pokemon_pluto.PokemonPluto;
import mrthomas20121.pokemon_pluto.api.json.JsonSerializer;
import mrthomas20121.pokemon_pluto.api.json.JsonUtil;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

public class AbstractHandler<T extends IHandlerEntry> {
    private final GameLocation name;
    protected final ObjectLinkedOpenHashSet<T> internalHashSet = new ObjectLinkedOpenHashSet<>();
    protected final ObjectLinkedOpenHashSet<String> locations = new ObjectLinkedOpenHashSet<>();
    private final JsonSerializer<T> serializer;

    private T defaultEntry;

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

    public void setDefaultEntry(T defaultEntry) {
        this.defaultEntry = defaultEntry;
    }

    public T getDefaultEntry() {
        return defaultEntry;
    }

    public JsonSerializer<T> getJsonSerializer() {
        return serializer;
    }

    public boolean register(T element) {
        if(locations.contains(element.getRegistryName().toString())) {
            PokemonPluto.getLogger().atWarning().withStackTrace(StackSize.LARGE).log("Cannot register %s %s because an element with the same registry name was registered before", this.getClassName(element),element.getRegistryName().toString());
            return false;
        }

        // add the registry name to the registry name list.
        this.locations.add(element.getRegistryName().toString());
        return this.internalHashSet.add(element);
    }

    public int size() {
        return this.internalHashSet.size();
    }

    public boolean isEmpty() {
        return this.internalHashSet.isEmpty();
    }

    public void registerFromJsonList(String file) {
        JsonArray array = JsonUtil.getResourceFromJson(file, JsonArray.class);
        this.serializer.deserialize(array).forEach(this::register);
    }

    public void registerFromJson(String file) {
        T object = JsonUtil.fromJson(this.serializer, file);
        PokemonPluto.getLogger().atInfo().log(object.getRegistryName().toString());
        register(object);
    }

    public void registerFromJson(String file, JsonSerializer<T> serializer) {
        T object = JsonUtil.fromJson(serializer, file);
        register(object);
    }

    /**
     * Get an Element by name.
     * @param name name
     * @return The Element with said name.
     */
    public T getElementByName(GameLocation name) {
        return this.internalHashSet.stream().filter(t -> t.getRegistryName().equals(name)).findFirst().orElse(defaultEntry);
    }

    public T getElement(int index) {
        return this.internalHashSet.get(index);
    }

    public ObjectLinkedOpenHashSet<T> getInternalHashSet() {
        return internalHashSet;
    }

    public GameLocation getRegistryName() {
        return this.name;
    }

    private String getClassName(T element) {
        return element.getClass().getSimpleName();
    }
}
