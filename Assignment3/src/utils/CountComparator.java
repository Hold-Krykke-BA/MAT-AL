package utils;

import java.util.Comparator;

/**
 * Use in place of a default Comparator
 * @param <T>
 */
public class CountComparator<T> implements Comparator<T> {

    private int count;
    private Comparator<T> original;

    public CountComparator(Comparator<T> original) {
        this.original = original;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void resetCount() {
        count = 0;
    }

    @Override
    public int compare(T o1, T o2) {
        return original.compare(o1, o2);
    }
}
