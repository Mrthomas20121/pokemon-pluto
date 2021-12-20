package mrthomas20121.pokemon_pluto.api.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;

public interface JsonSerializer<T> {
    T deserialize(JsonObject jsonObject);
    default ObjectLinkedOpenHashSet<T> deserialize(JsonArray jsonArray) {
        ObjectLinkedOpenHashSet<T> objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet<>();
        jsonArray.forEach(element -> objectLinkedOpenHashSet.add(deserialize(element.getAsJsonObject())));
        return objectLinkedOpenHashSet;
    }

    default JsonObject serialize(T obj) {
        return null;
    }
}
