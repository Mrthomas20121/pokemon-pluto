package mrthomas20121.pokemon_pluto.api.character;

import mrthomas20121.pokemon_pluto.api.pokemon.Pokemon;
import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;

import java.util.List;

public abstract class Trainer implements Character {

    protected String registryName;

    public Trainer(String registryName) {
        this.registryName = registryName;
    }

    @Override
    public String getRegistryName() {
        return registryName;
    }

    @Override
    public String getTranslationKey() {
        return String.format("character.trainer.%s.name", this.registryName);
    }

    @Override
    public boolean isTrainer() {
        return true;
    }

    public abstract List<PokemonData> getTeam();
}
