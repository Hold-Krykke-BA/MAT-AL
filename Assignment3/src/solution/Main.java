package solution;

import solution.sorts.HeapSort;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();

        Integer[] arrayI = {7, 4, 98, 3, 45, 3, 1, 45, 2, 7, 65, 12, 8, 77, 6};
        Double[] arrayD = {7.5, 4.4, 98.0, 3.2, 45.9, 3.4, 1.7, 45.1, 2.6, 7.4, 65.8, 12.1, 8.2, 77.3, 6.4};
        String[] arrayS = {"elephant", "paper", "drink", "glass", "lamp", "moon", "saturn", "venus", "sorter", "magic", "drill", "pace", "elastic", "globe", "gloss" };

        print(arrayI);
        System.out.println("Sorting Integer Array");
        sorter.sort(Comparator.naturalOrder(), arrayI);
        print(arrayI);

        print(arrayD);
        System.out.println("Sorting Double Array");
        sorter.sort(Comparator.naturalOrder(), arrayD);
        print(arrayD);

        print(arrayS);
        System.out.println("Sorting String Array");
        sorter.sort(Comparator.naturalOrder(), arrayS);
        print(arrayS);
        System.out.println(sorter.isSorted(Comparator.naturalOrder(), arrayS));

    }
    private static <T> void print(T[] array){
        System.out.println("***********************************");
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ": " + array[i]);
        }
        System.out.println("***********************************");
    }
}
