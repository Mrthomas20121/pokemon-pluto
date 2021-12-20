package mrthomas20121.pokemon_pluto.api.pokemon;

public enum Effectiveness {

    DOUBLE_EFFECTIVE(4),
    SUPER_EFFECTIVE(2),
    EFFECTIVE(1),
    NOT_VERY_EFFECTIVE(0.5),
    NO_EFFECT(0);

    private final double multiplicator;
    private final String key;

    Effectiveness(double multiplicator) {
        this.multiplicator = multiplicator;
        this.key = String.format("effectiveness.%s.name", this.name().toLowerCase());
    }

    public String getLangKey() {
        return key;
    }

    public double getMultiplicator() {
        return multiplicator;
    }
}
