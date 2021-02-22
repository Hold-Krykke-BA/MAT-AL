package solution.sorts;

public interface ISort {
    void sort(Comparable[] array);                              // Sort, different for each algorithm
    boolean less(Comparable one, Comparable other);             // Comparison between one and other
    void exchange(Comparable[] array, int idx, int idxOther);   // Change value from index to other index
    void print(Comparable[] array);                             // Print array in a single line
    boolean isSorted(Comparable[] array);                       // Test if array is sorted
}
