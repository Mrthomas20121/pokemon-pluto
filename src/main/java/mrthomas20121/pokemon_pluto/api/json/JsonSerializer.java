package mrthomas20121.pokemon_pluto.api.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.LinkedList;
import java.util.List;

public interface JsonSerializer<T> {
    T deserialize(JsonObject jsonObject);
    default List<T> deserialize(JsonArray jsonArray) {
        List<T> list = new LinkedList<>();
        jsonArray.forEach(element -> list.add(deserialize(element.getAsJsonObject())));
        return list;
    }

    default JsonObject serialize(T obj) {
        return null;
    }
}
