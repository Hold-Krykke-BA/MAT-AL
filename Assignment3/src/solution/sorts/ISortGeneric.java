package solution.sorts;

import java.util.Comparator;

public interface ISortGeneric {
    /**
     * Sort method of choice
     *
     * @param comp  comparator of choice
     * @param array array of type of choice
     */
    <T> void sort(Comparator<T> comp, T[] array);

    /**
     * Checks if given array is sorted incrementally, by checking if [i] is smaller than [i+1]
     *
     * @param comp  comparator of choice
     * @param array array of type of choice
     * @param <T>
     * @return whether or not the array is sorted
     */
    default <T> boolean isSorted(Comparator<T> comp, T[] array){
        for (int i = 0; i < array.length - 1; i++) {
            if (comp.compare(array[i], array[i + 1]) > 0) return false; //should never occur if sorted incremental
        }
        return true;
    }

    /**
     * Prints an arrays contents
     *
     * @param array The array to be printed
     */
    default <T> void print(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Prints an arrays contents with an upper limit
     *
     * @param array The array to be printed
     * @param max   The maximum amount of values to be printed
     */
    default <T> void print(T[] array, int max) {
        int cutoff = max < array.length ? max : array.length;
        for (int i = 0; i < cutoff; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Prints an array using a custom start and end point.
     *
     * @param array array to print
     * @param start starting point in array (index)
     * @param end   ending point in array (index)
     * @param <T>
     */
    default <T> void print(T[] array, int start, int end) {
        int _start = (start < end && start >= 0) ? start : 0;
        int _end = (end > start && end <= array.length) ? end : array.length;
        for (int i = _start; i < _end; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
