package mrthomas20121.pokemon_pluto.api;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

public interface PlutoObject<T> {

    T setRegistryName(GameLocation registryName);
    GameLocation getRegistryName();
}
