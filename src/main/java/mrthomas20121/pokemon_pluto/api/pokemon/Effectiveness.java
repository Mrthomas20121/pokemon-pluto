package mrthomas20121.pokemon_pluto.api.pokemon;

public enum Effectiveness {

    DOUBLE_EFFECTIVE(4),
    SUPER_EFFECTIVE(2),
    EFFECTIVE(),
    NOT_VERY_EFFECTIVE(0.5),
    NO_EFFECT(0);

    private double multiplicator;

    Effectiveness(double multiplicator) {
        this.multiplicator = multiplicator;
    }

    Effectiveness() {
        this.multiplicator = 1;
    }

    public double getMultiplicator() {
        return multiplicator;
    }
}
