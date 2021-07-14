package mrthomas20121.pokemon_pluto.api.data;

public class Data<T> {

    protected T value;

    public Data(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
