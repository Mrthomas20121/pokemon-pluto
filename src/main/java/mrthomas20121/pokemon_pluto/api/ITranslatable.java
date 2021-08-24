package mrthomas20121.pokemon_pluto.api;

import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;

import java.util.LinkedList;
import java.util.List;

public interface ITranslatable extends IHandlerEntry {
    void setLangKey(String key);
    String getLangKey();
    default List<String> getValidLangKeys() { return new LinkedList<>(); }
}
