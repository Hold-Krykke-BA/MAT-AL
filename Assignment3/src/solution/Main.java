package solution;

import solution.sorts.MergeSort;
import utils.CountComparator;
import utils.FileUtility;
import utils.Stopwatch;

import java.io.IOException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        try {
            String[] shakespeare = FileUtility.toStringArray("src/data/shakespeare-complete-works.txt");
            //time("Insertion", shakespeare);
            //time("Selection", shakespeare);
            //time("Heap", shakespeare);
            time("Merge", shakespeare);
            //time("Trie", shakespeare);
        } catch (IOException e) {
            System.out.println("File not found -> " + e.getMessage());
        }
    }

    /**
     * Inspired by Algorithms pg. 255
     *
     * @param alg   Algorithm of choice
     * @param array array to sort
     * @return
     */
    private static void time(String alg, String[] array) {
        CountComparator<String> stringCountComparator = new CountComparator(Comparator.naturalOrder());
        System.out.printf("Initiating %ssort on an array of size %d.", alg, array.length);

        try (Stopwatch timer = new Stopwatch()) {
            //if (alg.equals("Insertion")) Insertion.sort(array);
            //if (alg.equals("Selection")) Selection.sort(array);
            //if (alg.equals("Heap")) Heap.sort(array);
            if (alg.equals("Merge")) {
                MergeSort ms = new MergeSort();
                ms.sort(stringCountComparator, array);
            }
            //if (alg.equals("Trie")) //what
        }
        System.out.print(" spent sorting.\n");
        System.out.printf("Comparisons: %d.", stringCountComparator.getCount());

        /* Check if array is sorted according to isSorted*/
        //MergeSort ms2 = new MergeSort();
        //System.out.println("Is array sorted according to MergeSort? " + ms2.isSorted(stringCountComparator, array));
    }
}
