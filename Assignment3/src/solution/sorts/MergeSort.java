package solution.sorts;

public class MergeSort {

    /**
     * Splits array recursively until only 1 is left and merges
     */
    void sort(int arr[], int left, int right) {
        if (left < right) { //If not already sorted
            int middle = left + (right - left) / 2;
            System.out.printf("Middle calculated: %d + (%d - %d) / 2 = %d", left, right, left, middle);
            System.out.println("\n");
            sort(arr, left, middle); //sort from 0...mid
            sort(arr, middle + 1, right); //sort from mid+1...end
            merge(arr, left, middle, right);
        } else {
            System.out.println("(Sort) Notice: else-statement hit. left >= right");
        }
    }

    /**
     * Performs the merge
     * @param arr original array
     * @param left left (start) pointer
     * @param middle middle pointer
     * @param right right (end) pointer
     */
    void merge(int arr[], int left, int middle, int right) {
        System.out.println("**Merging**");
        // Find sizes of two subarrays to be merged
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;
        System.out.printf("leftArraySize: %d-%d+1 = %d\n", middle, left, leftArraySize);
        System.out.printf("rightArraySize: %d-%d = %d\n", right, middle, rightArraySize);

        /* Create temp arrays */
        int leftTemp[] = new int[leftArraySize];
        int rightTemp[] = new int[rightArraySize];

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
            if (leftTemp[leftIdx] <= rightTemp[rightIdx]) { //left <= right
                arr[outerIdx] = leftTemp[leftIdx]; //set arr[k] to left value
                leftIdx++;
            } else {
                arr[outerIdx] = rightTemp[rightIdx]; //left >= right && set arr[k] to right value
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
        int arr[] = {15, 7, 12, 3, 9, 10, 2, 5, 3};

        System.out.println("array before:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        MergeSort ms = new MergeSort();
        ms.sort(arr, 0, arr.length - 1);

        System.out.println("\narray after:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
