package mrthomas20121.pokemon_pluto.api.pokemon;

public class PokemonData {

    private String pokemon_name;

    private int level;
    private double totalxp;

    private int ev;
    private int iv;

    private boolean xpGain;

    private int[] xpBonuses;

    private Object heldItem;

    public Pokemon getPokemon() {
        return null;// Manager.getPokemon();
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
}
