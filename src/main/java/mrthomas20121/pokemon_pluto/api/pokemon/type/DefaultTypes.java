package mrthomas20121.pokemon_pluto.api.pokemon.type;

import mrthomas20121.pokemon_pluto.api.pokemon.Effectiveness;

public class DefaultTypes {

    public static PokemonType NORMAL = new PokemonType("normal") {
        @Override
        public Effectiveness getEffectiveness(PokemonType type) {
            switch (type.getName()) {
                case "ghost":
                    return Effectiveness.NO_EFFECT;
                case "rock":
                case "steel":
                    return Effectiveness.NOT_VERY_EFFECTIVE;
            }
            return Effectiveness.EFFECTIVE;
        }
    };

    public static PokemonType FIRE = new PokemonType("fire") {
        @Override
        public Effectiveness getEffectiveness(PokemonType type) {
            switch (type.getName()) {
                case "water":
                case "rock":
                case "fire":
                case "dragon":
                    return Effectiveness.NOT_VERY_EFFECTIVE;
                case "grass":
                case "ice":
                case "bug":
                case "steel":
                    return Effectiveness.SUPER_EFFECTIVE;
            }
            return Effectiveness.EFFECTIVE;
        }
    };

    public static PokemonType WATER = new PokemonType("water") {
        @Override
        public Effectiveness getEffectiveness(PokemonType type) {
            switch (type.getName()) {
                case "fire":
                case "ground":
                case "rock":
                    return Effectiveness.SUPER_EFFECTIVE;
                case "water":
                case "grass":
                case "dragon":
                    return Effectiveness.NOT_VERY_EFFECTIVE;



            }
            return Effectiveness.EFFECTIVE;
        }
    };
}
