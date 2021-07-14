package mrthomas20121.pokemon_pluto.api.manager;

import mrthomas20121.pokemon_pluto.api.pokemon.move.*;

import java.util.List;

public class MoveManager extends Manager<Move> {

    public List<Move> getObtainableMove() {
        return this.value.stream().filter(move -> !(move instanceof NonObtainableMove)).toList();
    }

    public List<Move> getCSMoves() {
        return this.value.stream().filter(move -> move instanceof CSMove).toList();
    }

    public List<Move> getHMMoves() {
        return this.value.stream().filter(move -> move instanceof HMMove).toList();
    }

    public List<Move> getPhysicalMoves() {
        return this.value.stream().filter(move -> move.getCategory().equals(Category.PHYSICAL)).toList();
    }

    public List<Move> getSpecialMoves() {
        return this.value.stream().filter(move -> move.getCategory().equals(Category.SPECIAL)).toList();
    }

    public List<Move> getStatusMoves() {
        return this.value.stream().filter(move -> move.getCategory().equals(Category.STATUS)).toList();
    }
}
