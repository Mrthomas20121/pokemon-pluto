package mrthomas20121.pokemon_pluto.api;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import mrthomas20121.pokemon_pluto.api.json.JsonUtil;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Translation {

    private static Map<String, String> entries = new LinkedHashMap<>();

    public static Map<String, String> getTranslations() {
        return entries;
    }

    /**
     * Used to load translations
     * @param file translation file. must be a valid json file
     */
    public static void loadTranslations(String file) {
        InputStream input = Translation.class.getClassLoader().getResourceAsStream(file);
        JsonReader reader = new JsonReader(new InputStreamReader(input));
        entries = JsonUtil.gson.fromJson(reader, new TypeToken<Map<String, String>>(){}.getType());
    }

    /**
     * Translate a lang entry.
     * @param lang
     * @return return the translation if it exists otherwise return the lang entry.
     */
    public static String translate(String lang) {
        if(entries.containsKey(lang) && !entries.get(lang).isEmpty()) return entries.get(lang);
        return lang;
    }
}
