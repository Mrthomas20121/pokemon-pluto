package mrthomas20121.pokemon_pluto.api.manager;

import com.google.gson.JsonObject;
import mrthomas20121.pokemon_pluto.api.data.SerialData;
import mrthomas20121.pokemon_pluto.api.JsonUtil;
import mrthomas20121.pokemon_pluto.api.data.Data;

import java.util.LinkedList;

public class Manager<T extends SerialData> extends Data<LinkedList<T>> {

    private boolean isEnabled;

    public Manager() {
        super(new LinkedList<>());
    }

    public <D extends SerialData> Manager<D> requireManager(Class<D> dClass) {
        return new Manager<>();
    }

    public boolean register(T element) {
        return this.value.add(element);
    }

    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setState(boolean enabled) {
        isEnabled = enabled;
    }

    public void registerFromJson(String file, Class<T> tClass) {
        register(JsonUtil.getResourceFromJson(file, tClass));
    }

    public T convertJsonTo(JsonObject object, Class<T> tClass) {
        return JsonUtil.gson.fromJson(object, tClass);
    }

    /**
     * Get an Element by name.
     * Override this if you wish to return a default value if the name doesn't exists. by default it return null.
     * @param name name
     * @return The Element with said name.
     */
    public T getElementByName(String name) {
        return this.value.stream().filter(t -> t.getRegistryName().equals(name)).findFirst().orElse(null);
    }

    public T getElement(int index) {
        return this.value.get(index);
    }
}
