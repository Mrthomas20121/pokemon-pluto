package mrthomas20121.pokemon_pluto.api.helper;

import java.util.LinkedList;
import java.util.List;

public class InternalList<T> {

    protected final List<T> internalList = new LinkedList<>();

    public boolean add(T element) {
        return this.internalList.add(element);
    }

    public T get(int i) {
        return this.internalList.get(i);
    }

    public List<T> getInternalList() {
        return internalList;
    }
}
