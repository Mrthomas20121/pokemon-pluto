package mrthomas20121.pokemon_pluto.api.item.effect;

import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;

import java.util.List;

public class LevelupEffect implements ItemEffect {

    @Override
    public void onPokemonUse(PokemonData pokemon) {
        pokemon.levelupRareCandy();
    }

    @Override
    public void beforeItemUse(List<PokemonData> pokemonList) {

    }

    @Override
    public void afterDamage(PokemonData pokemon) {

    }

    @Override
    public void afterHeal(PokemonData pokemon) {

    }

    @Override
    public void onTurnStart(PokemonData pokemon) {

    }

    @Override
    public void onTurnEnd(PokemonData pokemon) {

    }

    @Override
    public void onPokemonEvolve(PokemonData pokemon) {

    }
}
