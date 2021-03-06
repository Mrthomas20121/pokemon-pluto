package mrthomas20121.pokemon_pluto.api.handler;

import mrthomas20121.pokemon_pluto.api.item.ItemRareCandy;
import mrthomas20121.pokemon_pluto.api.pokemon.Pokemon;
import mrthomas20121.pokemon_pluto.api.pokemon.PokemonSerializer;

public class GameManager {

    public static ItemHandler itemHandler = new ItemHandler();

    public static MoveHandler moveHandler = new MoveHandler();

    public static PokemonTypeHandler pokemonTypeHandler = new PokemonTypeHandler();

    public static AbstractHandler<Pokemon> pokemonAbstractHandler = new AbstractHandler<>("pluto:pokemon", new PokemonSerializer());

    static {
        // register Rare Candy
        itemHandler.register(new ItemRareCandy("pluto"));

        //pokemonTypeHandler.registerFromJsonList("types.json");
    }
}
