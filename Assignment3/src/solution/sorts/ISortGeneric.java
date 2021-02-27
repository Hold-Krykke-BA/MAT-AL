package solution.sorts;

import java.util.Comparator;

public interface ISortGeneric {
    <T> void sort(Comparator<T> comp, T[]array);            // Sort, different for each algorithm
    <T> boolean isSorted(Comparator<T> comp, T[]array);     // Test if array is sorted
}
