package mrthomas20121.pokemon_pluto.api.handler;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;

public interface IHandlerEntry {

    GameLocation getRegistryName();

    GameTranslation getTranslationKey();
}
