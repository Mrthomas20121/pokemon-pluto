package mrthomas20121.pokemon_pluto.api.handler;

import mrthomas20121.pokemon_pluto.api.pokemon.move.*;

import java.util.List;

public class MoveHandler extends AbstractHandler<Move> {

    public MoveHandler() {
        super("pluto:move");
    }

    public List<Move> getObtainableMove() {
        return this.internalList.stream().filter(move -> !(move instanceof NonObtainableMove)).toList();
    }

    @Override
    public boolean register(Move element) {
        if(element.getCategory() == null) {
            throw new NullPointerException("Move category is null");
        }
        return super.register(element);
    }

    public List<Move> getCSMoves() {
        return this.internalList.stream().filter(move -> move instanceof CSMove).toList();
    }

    public List<Move> getHMMoves() {
        return this.internalList.stream().filter(move -> move instanceof HMMove).toList();
    }

    public List<Move> getPhysicalMoves() {
        return this.internalList.stream().filter(move -> move.getCategory().equals(Category.PHYSICAL)).toList();
    }

    public List<Move> getSpecialMoves() {
        return this.internalList.stream().filter(move -> move.getCategory().equals(Category.SPECIAL)).toList();
    }

    public List<Move> getStatusMoves() {
        return this.internalList.stream().filter(move -> move.getCategory().equals(Category.STATUS)).toList();
    }
}
