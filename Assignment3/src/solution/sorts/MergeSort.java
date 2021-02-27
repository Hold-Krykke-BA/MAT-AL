package solution.sorts;

import utils.CountComparator;

import java.util.Comparator;

public class MergeSort implements ISortGeneric {

    @Override
    public <T> void sort(Comparator<T> comp, T[] array) {
        sort(array, 0, array.length - 1, comp);
    }

    @Override
    public <T> boolean isSorted(Comparator<T> comp, T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comp.compare(array[i], array[i + 1]) > 0) return false; //should never occur if sorted incremental
        }
        return true;
    }

    /**
     * Splits array recursively until only 1 is left and merges
     *
     * @param arr
     * @param left
     * @param right
     */
    private <T> void sort(T[] arr, int left, int right, Comparator<T> comp) {
        if (left < right) { //If not already sorted
            int middle = left + (right - left) / 2;
            System.out.printf("Middle calculated: %d + (%d - %d) / 2 = %d", left, right, left, middle);
            System.out.println("\n");
            sort(arr, left, middle, comp); //sort from 0...mid
            sort(arr, middle + 1, right, comp); //sort from mid+1...end
            merge(arr, left, middle, right, comp);
        } else {
            System.out.println("(Sort) Notice: Recursive function broken. (left >= right)");
        }
    }

    /**
     * Performs the merge
     *
     * @param arr    original array
     * @param left   left (start) pointer
     * @param middle middle pointer
     * @param right  right (end) pointer
     */
    private <T> void merge(T[] arr, int left, int middle, int right, Comparator<T> comp) {
        System.out.println("**Merging**");
        // Find sizes of two subarrays to be merged
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;
        System.out.printf("leftArraySize: %d-%d+1 = %d\n", middle, left, leftArraySize);
        System.out.printf("rightArraySize: %d-%d = %d\n", right, middle, rightArraySize);

        /* Create temp arrays */
        T[] leftTemp = (T[]) new Object[leftArraySize];
        T[] rightTemp = (T[]) new Object[rightArraySize];

        /*Copy data to temp arrays*/
        for (int i = 0; i < leftArraySize; ++i)
            leftTemp[i] = arr[left + i];
        for (int j = 0; j < rightArraySize; ++j)
            rightTemp[j] = arr[middle + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of temporary arrays (leftTemp & rightTemp)
        int leftIdx = 0, rightIdx = 0;

        // Initial index of merged subarray array
        int outerIdx = left; //starting point (be it 0 or mid+1)
        while (leftIdx < leftArraySize && rightIdx < rightArraySize) {
            if (comp.compare(leftTemp[leftIdx], rightTemp[rightIdx]) <= 0) { //left <= right
                arr[outerIdx] = leftTemp[leftIdx]; //set arr[outerIdx] to left value
                leftIdx++;
            } else {
                arr[outerIdx] = rightTemp[rightIdx]; //left >= right && set arr[outerIdx] to right value
                rightIdx++;
            }
            outerIdx++;
        }

        /* Copy remaining elements if uneven array length*/

        /* Copy remaining elements of L[] if any */
        while (leftIdx < leftArraySize) {
            System.out.println("(Merge) Notice: Found remaining elements in left\n");
            arr[outerIdx] = leftTemp[leftIdx];
            leftIdx++;
            outerIdx++;
        }

        /* Copy remaining elements of R[] if any */
        while (rightIdx < rightArraySize) {
            System.out.println("(Merge) Notice: Found remaining elements in left\n");
            arr[outerIdx] = rightTemp[rightIdx];
            rightIdx++;
            outerIdx++;
        }
    }

    public static void main(String[] args) {
        System.out.println("***Integer test start***");
        Integer arr[] = {15, 7, 12, 3, 9, 10, 2, 5, 3};
        CountComparator<Integer> integerCount = new CountComparator(Comparator.naturalOrder());
        MergeSort ms = new MergeSort();

        System.out.println("array before:");
        ms.print(arr);
        System.out.println("\nIs it sorted before? " + ms.isSorted(integerCount, arr));

        ms.sort(arr, 0, arr.length - 1, integerCount);

        System.out.println("\narray after:");
        ms.print(arr);

        System.out.println("");
        System.out.println("Is it sorted after? " + ms.isSorted(integerCount, arr));
        System.out.println("Compares: " + integerCount.getCount());
        System.out.println("***Integer test end***");


        System.out.println("***Double test start***");
        Double array[] = {15.0, 7.5, 12.2, 3.2, 9.1, 10.5, 2.7, 5.3, 3.9};
        CountComparator<Double> DoubleCount = new CountComparator(Comparator.naturalOrder());
        MergeSort msDouble = new MergeSort();

        System.out.println("array before:");
        msDouble.print(array);
        System.out.println("\nIs it sorted before? " + msDouble.isSorted(DoubleCount, array));

        msDouble.sort(array, 0, array.length - 1, DoubleCount);

        System.out.println("\narray after:");
        msDouble.print(array);

        System.out.println("");
        System.out.println("Is it sorted after? " + msDouble.isSorted(DoubleCount, array));
        System.out.println("Compares: " + DoubleCount.getCount());
        System.out.println("***Double test end***");
    }
}
