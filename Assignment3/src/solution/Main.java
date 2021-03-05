package solution;

import solution.sorts.*;
import utils.CountComparator;
import utils.FileUtility;
import utils.Stopwatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String[] shakespeare = FileUtility.toStringArray("src/data/shakespeare-complete-works.txt");
            //time("Insertion", shakespeare);
            //time("Selection", shakespeare);
            //time("Heap", shakespeare);
            //time("Merge", shakespeare);
            time("Trie", shakespeare);
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
        //compares by natural order ("Lexicographic" order)
        CountComparator<String> stringCountComparator = new CountComparator(Comparator.naturalOrder());

        /*
        CountComparator<String> stringCountComparator = new CountComparator(new Comparator<String>() {
            //compares by length
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return 1;
                else if (o1.length() < o2.length()) return -1;
                else return 0;
            }
        });
         */

        System.out.printf("Initiating %ssort on an array of size %d.", alg, array.length);

        try (Stopwatch timer = new Stopwatch()) {
            if (alg.equals("Insertion")) {
                InsertionSort insertion = new InsertionSort();
                insertion.sort(stringCountComparator, array);
            }
            if (alg.equals("Selection")) {
                SelectionSort selection = new SelectionSort();
                selection.sort(stringCountComparator, array);
            }
            if (alg.equals("Heap")) {
                HeapSort heapsort = new HeapSort();
                heapsort.sort(stringCountComparator, array);
                //System.out.println("\n");
                //heapsort.print(array, 100000, 100050);
            }
            if (alg.equals("Merge")) {
                MergeSort ms = new MergeSort();
                ms.sort(stringCountComparator, array);
            }
            if (alg.equals("Trie")){
                Trie trie = new Trie();
                trie.buildTrie(array);
//                Uncomment below to get all words printed in console
//                Uncomment line 72, 75 and 77 in Trie to get a count
//                of all inserted words printed in console

//                System.out.println("\n\n");
//                List<String> listWords = new ArrayList<>();
//                trie.traverse(listWords);
//                for (int i = 0; i < listWords.size(); i++) {
//                    System.out.println(listWords.get(i));
//                }
            }
        }
        System.out.print(" spent sorting.\n");
        System.out.printf("Comparisons: %d.", stringCountComparator.getCount());

        /* Check if array is sorted according to isSorted*/
        //MergeSort ms2 = new MergeSort();
        //System.out.println("Is array sorted according to MergeSort? " + ms2.isSorted(stringCountComparator, array));
    }
}
