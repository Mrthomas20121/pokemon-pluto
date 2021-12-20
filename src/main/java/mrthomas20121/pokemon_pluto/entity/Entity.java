package mrthomas20121.pokemon_pluto.entity;

import mrthomas20121.pokemon_pluto.api.handler.IHandlerEntry;
import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.api.helper.GameTranslation;

import java.util.Objects;

public class Entity implements IHandlerEntry {

    private final GameLocation registryName;
    protected Pos pos = new Pos();

    // determine whether the entity does its movements check or not
    private boolean hasAI;

    public Entity(String entityName) {
        this.registryName = new GameLocation("pluto", entityName);
    }

    public Entity(GameLocation registryName) {
        this.registryName = registryName;
    }

    public void setPosition(int x, int y) {
        this.pos.setX(x).setY(y);
    }

    public void setPosition(Pos pos) {
        this.pos = pos;
    }

    public void setHasAI(boolean hasAI) {
        this.hasAI = hasAI;
    }

    public boolean isAIActive() {
        return hasAI;
    }

    @Override
    public GameLocation getRegistryName() {
        return this.registryName;
    }

    @Override
    public GameTranslation getTranslationKey() {
        return new GameTranslation(String.format("entity.%s.name", this.registryName.getPath()));
    }

    /**
     * Store the position of the entity.
     */
    public static final class Pos {

        private int x;
        private int y;
        private Facing face;

        public enum Facing {
            LEFT,
            RIGHT,
            UP,
            DOWN
        }

        public Pos() {}

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Pos setX(int x) {
            this.x = x;
            return this;
        }

        public Pos setY(int y) {
            this.y = y;
            return this;
        }

        public Pos up() {
            this.face = Facing.UP;
            return this;
        }

        public Pos down() {
            this.face = Facing.DOWN;
            return this;
        }

        public Pos left() {
            this.face = Facing.LEFT;
            return this;
        }

        public Pos right() {
            this.face = Facing.RIGHT;
            return this;
        }


        public Pos setFace(Facing face) {
            this.face = face;
            return this;
        }

        public Pos setFace(String face) {
            this.face = Facing.valueOf(face);
            return this;
        }

        public Facing getFace() {
            return face;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        public boolean equalsOR(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x || y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
