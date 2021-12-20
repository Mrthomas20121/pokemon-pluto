package mrthomas20121.pokemon_pluto.api;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public interface JsonInterface<T extends PlutoObject<T>> extends JsonSerializer<T>, JsonDeserializer<T> {

}
