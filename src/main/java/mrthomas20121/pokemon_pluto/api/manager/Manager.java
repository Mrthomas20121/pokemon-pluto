package mrthomas20121.pokemon_pluto.api.manager;

import mrthomas20121.pokemon_pluto.api.pokemon.move.*;
import mrthomas20121.pokemon_pluto.api.pokemon.type.PokemonType;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Manager {

    private static List<PokemonType> types = new LinkedList<>();
    private static List<Move> moves = new LinkedList<>();

    private static int maxCSMoves = 8;
    private static int maxHMMoves = 100;

    public static void setMaxCSMoves(int nb)  {
        maxCSMoves = nb;
    }

    public static void setMaxHMMoves(int nb) {
        maxHMMoves = nb;
    }

    public static void registerType(PokemonType type) {
        types.add(type);
    }

    public static boolean registerMove(Move move) {
        return moves.add(move);
    }

    /**
     * register a Non Obtainable move, return true if it was added successfully. return false if the move number is higher than the max possible
     * @param move Non Obtainable move
     * @return
     */
    public static boolean registerNonObtainableMove(NonObtainableMove move) {
        if((move instanceof HMMove && move.getNumber() > maxHMMoves) || move instanceof CSMove && move.getNumber() > maxCSMoves) {
            //todo log that the move exceed the HM/CS moves capacity
            return false;
        }

        return registerMove(move);
    }

    /**
     * Return all moves
     * @return all moves
     */
    public static List<Move> getMoves() {
        return moves;
    }

    public static List<PokemonType> getTypes() {
        return types;
    }

    public static List<Move> getObtainableMove() {
        return moves.stream().filter(move -> !(move instanceof NonObtainableMove)).collect(Collectors.toList());
    }

    public static List<Move> getCSMoves() {
        return moves.stream().filter(move -> move instanceof CSMove).collect(Collectors.toList());
    }

    public static List<Move> getHMMoves() {
        return moves.stream().filter(move -> move instanceof HMMove).collect(Collectors.toList());
    }

    public static List<Move> getPhysicalMoves() {
        return moves.stream().filter(move -> move.getCategory().equals(Category.PHYSICAL)).collect(Collectors.toList());
    }

    public static List<Move> getSpecialMoves() {
        return moves.stream().filter(move -> move.getCategory().equals(Category.SPECIAL)).collect(Collectors.toList());
    }

    public static List<Move> getStatusMoves() {
        return moves.stream().filter(move -> move.getCategory().equals(Category.STATUS)).collect(Collectors.toList());
    }

    public void init() {

    }
}
