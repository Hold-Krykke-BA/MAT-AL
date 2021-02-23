package solution.sorts;

public interface ISort {
    void sort(Comparable[] array);                              // Sort, different for each algorithm
    boolean less(Comparable one, Comparable other);             // Comparison between one and other
    void exchange(Comparable[] array, int idx, int idxOther);   // Change value from index to other index

    /**
     * @param array The array to be printed
     */
    default void print(Comparable[] array) {                    // Print array in a single line
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    /**
     * @param array The array to be printed
     * @param max The maximum amount of values to be printed
     */
    default void print(Comparable[] array, int max) {           // Print array in a single line, with a max output parameter
        int n = array.length;
        int m = max;
        if (n > m) n = m;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    boolean isSorted(Comparable[] array);                       // Test if array is sorted
}
