package mrthomas20121.pokemon_pluto.api.manager;

import mrthomas20121.pokemon_pluto.api.item.ItemRareCandy;
import mrthomas20121.pokemon_pluto.api.pokemon.Pokemon;
import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

public class GameManager {

    public static ItemManager itemManager = new ItemManager();

    public static MoveManager moveManager = new MoveManager();

    public static Manager<PokemonType> typeManager = new Manager<>();

    public static Manager<Pokemon> pokemonManager = new Manager<>().requireManager(null);

    private static Manager<PokemonData> internalData = new Manager<>();

    static {
        // register Rare Candy
        itemManager.register(new ItemRareCandy());
    }
}
