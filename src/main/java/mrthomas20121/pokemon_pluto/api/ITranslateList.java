package mrthomas20121.pokemon_pluto.api;

import java.util.LinkedList;
import java.util.List;

public class ITranslateList<T extends ITranslatable> {

    private final List<T> list = new LinkedList<>();

    public ITranslateList() {

    }

    public boolean addTranslation(T element) {
        return this.list.add(element);
    }

    public T get(int i) {
        return this.list.get(i);
    }
}
