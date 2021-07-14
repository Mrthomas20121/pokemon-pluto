package mrthomas20121.pokemon_pluto.api.data;

public class Tile<T> extends Data<T> implements SerialData {

    public Tile(T value) {
        super(value);
    }

    @Override
    public String getRegistryName() {
        return value.toString();
    }
}
