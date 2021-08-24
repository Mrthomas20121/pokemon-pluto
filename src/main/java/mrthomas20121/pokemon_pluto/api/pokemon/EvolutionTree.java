package mrthomas20121.pokemon_pluto.api.pokemon;

public class EvolutionTree {

    private final String evolution1;
    private String evolution2;
    private String evolution3;

    public EvolutionTree(String evolution1) {
        this.evolution1 = evolution1;
    }

    public EvolutionTree(String evolution1, String evolution2) {
        this(evolution1);
        this.evolution2 = evolution2;
    }

    public EvolutionTree(String evolution1, String evolution2, String evolution3) {
        this(evolution1, evolution2);
        this.evolution3 = evolution3;
    }

    public String getEvolution1() {
        return evolution1;
    }

    public String getEvolution2() {
        return evolution2;
    }

    public String getEvolution3() {
        return evolution3;
    }
}
