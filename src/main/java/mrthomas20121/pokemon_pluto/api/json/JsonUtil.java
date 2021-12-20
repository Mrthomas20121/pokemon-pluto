package mrthomas20121.pokemon_pluto.api.json;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import mrthomas20121.pokemon_pluto.PokemonPluto;
import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;

import java.io.IOException;
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
        InputStream input = getStreamFromFile(file);
        JsonReader reader = new JsonReader(new InputStreamReader(input));
        return gson.fromJson(reader, tClass);
    }

    public static String toJson(JsonObject object) {
        return gson.toJson(object);
    }

    public static InputStream getStreamFromFile(String file) {
        return JsonUtil.class.getClassLoader().getResourceAsStream(file);
    }

    public static <T extends IHandlerEntry> T fromJson(JsonSerializer<T> tClass, String file) {
        InputStream inputStream = getStreamFromFile(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        JsonObject jsonObject = gson.fromJson(inputStreamReader, JsonObject.class);
        try {
            inputStream.close();
            inputStreamReader.close();
        }
        catch (IOException e) {
            PokemonPluto.getLogger().atSevere().withCause(e).log("Unable to close stream");
        }
        return tClass.deserialize(jsonObject);
    }
}
