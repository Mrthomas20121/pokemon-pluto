package mrthomas20121.pokemon_pluto.api.pokemon;

import mrthomas20121.pokemon_pluto.api.ITranslatable;

public enum Effectiveness implements ITranslatable {

    DOUBLE_EFFECTIVE(4),
    SUPER_EFFECTIVE(2),
    EFFECTIVE(),
    NOT_VERY_EFFECTIVE(0.5),
    NO_EFFECT(0);

    private final double multiplicator;
    private String key;

    Effectiveness(double multiplicator) {
        this.multiplicator = multiplicator;
        this.key = String.format("effectiveness.%s.name", this.name().toLowerCase());
    }

    Effectiveness() {
        this.multiplicator = 1;
    }

    @Override
    public void setLangKey(String key) {
        this.key = key;
    }

    public String getLangKey() {
        return key;
    }

    @Override
    public String getRegistryName() {
        return this.name().toLowerCase();
    }

    public double getMultiplicator() {
        return multiplicator;
    }
}
