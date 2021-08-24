package mrthomas20121.pokemon_pluto.api.item;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.item.effect.LevelupEffect;
import mrthomas20121.pokemon_pluto.api.pokemon.PokemonData;

import java.util.List;

public class ItemRareCandy extends Item {

    public ItemRareCandy(String name) {
        super(new GameLocation(name, "rarecandy"));
    }

    public ItemRareCandy(GameLocation name) {
        super(name);
        this.setEffect(new LevelupEffect());
    }

    @Override
    public ItemCategory getCategory() {
        return ItemCategory.STATUS_AND_HEAL;
    }
}
