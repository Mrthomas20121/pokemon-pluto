package mrthomas20121.pokemon_pluto.api;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import mrthomas20121.pokemon_pluto.api.manager.Manager;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class JsonUtil {

    public static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static List<String> getListFromJsonArray(JsonArray array) {
        List<String> output = new LinkedList<>();
        array.forEach(jsonElement -> output.add(jsonElement.getAsString()));
        return output;
    }

    public static <T> T getResourceFromJson(String file, Class<T> tClass) {
        InputStream input = JsonUtil.class.getClassLoader().getResourceAsStream(file);
        JsonReader reader = new JsonReader(new InputStreamReader(input));
        return gson.fromJson(reader, tClass);
    }

    public static JsonObject getObjectFromJson(String file) {
        return getResourceFromJson(file, JsonObject.class);
    }
}
