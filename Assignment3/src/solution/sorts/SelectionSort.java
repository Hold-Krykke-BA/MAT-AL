package solution.sorts;

import utils.CountComparator;

import java.util.Comparator;

public class SelectionSort implements ISortGeneric {

    @Override
    public <T> void sort(Comparator<T> comp, T[] array) {
        selectionSort(array, comp);
    }

    private <T> void selectionSort(T[] arr, Comparator<T> comp) {
        int indexCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            T pivot = arr[indexCounter];
            int pivotIndex = indexCounter;
            for (int j = indexCounter; j < arr.length; j++) {
                if (comp.compare(pivot, arr[j]) > 0) {
                    pivot = arr[j];
                    pivotIndex = j;
                }
            }
            T temp = arr[indexCounter];
            arr[indexCounter] = pivot;
            arr[pivotIndex] = temp;
            indexCounter++;
        }
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();

        System.out.println("***Integer test start***");
        Integer[] arrInt = {5,2,7,12,9,11,1,1,9,34,7,0};
        CountComparator<Integer> integerCount = new CountComparator(Comparator.naturalOrder());

        System.out.println("array before:");
        ss.print(arrInt);
        System.out.println("\nIs it sorted before? " + ss.isSorted(integerCount, arrInt));

        ss.sort(integerCount, arrInt);

        System.out.println("\narray after:");
        ss.print(arrInt);

        System.out.println("");
        System.out.println("Is it sorted after? " + ss.isSorted(integerCount, arrInt));
        System.out.println("Compares: " + integerCount.getCount());
        System.out.println("***Integer test end***");

        System.out.println("***Double test start***");
        Double[] arrDouble = {15.0, 7.5, 12.2, 3.2, 9.1, 10.5, 2.7, 5.3, 3.9};
        CountComparator<Double> DoubleCount = new CountComparator(Comparator.naturalOrder());

        System.out.println("array before:");
        ss.print(arrDouble);
        System.out.println("\nIs it sorted before? " + ss.isSorted(DoubleCount, arrDouble));

        ss.sort(DoubleCount, arrDouble);

        System.out.println("\narray after:");
        ss.print(arrDouble);

        System.out.println("");
        System.out.println("Is it sorted after? " + ss.isSorted(DoubleCount, arrDouble));
        System.out.println("Compares: " + DoubleCount.getCount());
        System.out.println("***Double test end***");

        System.out.println("***String test start***");
        String[] arrString = {"to", "be", "or", "not", "to", "be"};
        CountComparator<String> StringCount = new CountComparator(Comparator.naturalOrder());

        System.out.println("array before:");
        ss.print(arrString);
        System.out.println("\nIs it sorted before? " + ss.isSorted(StringCount, arrString));

        ss.sort(StringCount, arrString);

        System.out.println("\narray after:");
        ss.print(arrString);

        System.out.println("");
        System.out.println("Is it sorted after? " + ss.isSorted(StringCount, arrString));
        System.out.println("Compares: " + StringCount.getCount());
        System.out.println("***String test end***");
    }

}
