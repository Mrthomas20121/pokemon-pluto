package mrthomas20121.pokemon_pluto.api.pokemon;

import mrthomas20121.pokemon_pluto.api.handler.GameManager;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;
import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;
import mrthomas20121.pokemon_pluto.api.item.Item;

/**
 * PokemonData.java -
 * @author Mrthomas20121
 * This class contain the data of a pokemon.
 *
 *
 * pokemon_name - This is the pokemon name.
 * starting_level - This is the level you found the pokemon at.
 * level - This is the current pokemon level.
 * totalxp - This is the amount of xp the pokemon have.
 * ev - The pokemon ev.
 * iv - The pokemon iv.
 * xpGain - Whether or not the pokemon should receive xp.
 * xpBonuses - This is the XP Bonuses From outside source(Item and other stuff, e.g multi exp)
 * heldItem - The Item Held by the pokemon
 */
public class PokemonData implements IHandlerEntry {

    private Pokemon pokemon;
    private int starting_level;
    private int level;
    private double totalxp;

    private int ev;
    private int iv;

    private boolean xpGain;

    private int[] xpBonuses;

    private Item heldItem;

    public PokemonData(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon get() {
        return pokemon;
    }

    public void setXPGain(boolean xpGain) {
        this.xpGain = xpGain;
    }

    public boolean canGainXP() {
        return xpGain;
    }

    public int getLevel() {
        return level;
    }

    public int getEv() {
        return ev;
    }

    public int getIv() {
        return iv;
    }

    public int[] getXpBonuses() {
        return xpBonuses;
    }

    public double getTotalxp() {
        return totalxp;
    }

    public void levelup() {
        this.level++;
    }

    public void evolve() {
        if(this.pokemon.canEvolve()) {
            EvolutionTree evolutionTree = this.pokemon.getEvolutionTree();
            this.pokemon = GameManager.pokemonAbstractHandler.getElementByName(new GameLocation(evolutionTree.getEvolution2()));
        }
    }

    public void levelupRareCandy() {
        this.levelup();
        // reset xp on level up
        this.totalxp = 0;
    }

    @Override
    public GameLocation getRegistryName() {
        return this.pokemon.getRegistryName();
    }

    @Override
    public GameTranslation getTranslationKey() {
        return this.pokemon.getTranslationKey();
    }
}
