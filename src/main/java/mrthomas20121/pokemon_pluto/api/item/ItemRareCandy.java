package mrthomas20121.pokemon_pluto.api.item;

import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;

import java.util.List;

public class ItemRareCandy extends Item {

    public ItemRareCandy() {
        super("rarecandy");
    }

    public ItemRareCandy(String name) {
        super(name);
    }

    @Override
    public void onPokemonUse(PokemonData pokemon) {
        pokemon.levelup();
    }

    @Override
    public void onUse(List<PokemonData> pokemonList) {

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
    public ItemCategory getCategory() {
        return ItemCategory.STATUS_AND_HEAL;
    }
}
