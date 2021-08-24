package mrthomas20121.pokemon_pluto.api.pokedex;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

public interface IPokedex {

    GameLocation getName();

    String getDescription();

    String getTranslatedDescription();

    String getTranslatedName();
}
