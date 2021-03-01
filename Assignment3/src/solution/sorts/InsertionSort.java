package solution.sorts;

import utils.CountComparator;

import java.util.Comparator;

public class InsertionSort implements ISortGeneric {

    @Override
    public <T> void sort(Comparator<T> comp, T[] array) {
        insertionSort(array, comp);
    }

    private <T> void insertionSort(T[] arr, Comparator<T> comp) {

        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && comp.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();

        System.out.println("***Integer test start***");
        Integer[] arrInt = {5,2,7,12,6,9,11,1,1,9,34,7,0};
        CountComparator<Integer> integerCount = new CountComparator(Comparator.naturalOrder());

        System.out.println("array before:");
        is.print(arrInt);
        System.out.println("\nIs it sorted before? " + is.isSorted(integerCount, arrInt));

        is.sort(integerCount, arrInt);

        System.out.println("\narray after:");
        is.print(arrInt);

        System.out.println("");
        System.out.println("Is it sorted after? " + is.isSorted(integerCount, arrInt));
        System.out.println("Compares: " + integerCount.getCount());
        System.out.println("***Integer test end***");

        System.out.println("***Double test start***");
        Double[] arrDouble = {15.0, 7.5, 12.2, 3.2, 9.1, 10.5, 2.7, 5.3, 3.9};
        CountComparator<Double> DoubleCount = new CountComparator(Comparator.naturalOrder());

        System.out.println("array before:");
        is.print(arrDouble);
        System.out.println("\nIs it sorted before? " + is.isSorted(DoubleCount, arrDouble));

        is.sort(DoubleCount, arrDouble);

        System.out.println("\narray after:");
        is.print(arrDouble);

        System.out.println("");
        System.out.println("Is it sorted after? " + is.isSorted(DoubleCount, arrDouble));
        System.out.println("Compares: " + DoubleCount.getCount());
        System.out.println("***Double test end***");

        System.out.println("***String test start***");
        String[] arrString = {"to", "be", "or", "not", "to", "be"};
        CountComparator<String> StringCount = new CountComparator(Comparator.naturalOrder());

        System.out.println("array before:");
        is.print(arrString);
        System.out.println("\nIs it sorted before? " + is.isSorted(StringCount, arrString));

        is.sort(StringCount, arrString);

        System.out.println("\narray after:");
        is.print(arrString);

        System.out.println("");
        System.out.println("Is it sorted after? " + is.isSorted(StringCount, arrString));
        System.out.println("Compares: " + StringCount.getCount());
        System.out.println("***String test end***");
    }
}
