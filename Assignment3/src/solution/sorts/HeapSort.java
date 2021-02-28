package solution.sorts;

import java.util.Comparator;

public class HeapSort implements ISortGeneric{
    private int heapSize;

    /**
     * Binary Heap is a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible).
     *
     * Links for readme:
     *
     * heap sort:
     * https://www.baeldung.com/java-heap-sort
     * https://www.geeksforgeeks.org/heap-sort/
     *
     * build heap explanation
     * https://stackoverflow.com/a/52613602
     *
     * leaf structure
     * https://www.geeksforgeeks.org/leaf-starting-point-binary-heap-data-structure/
     *
     *  unsorted
     *  {8, 2, 6, 4, 0, 3}
     *  index is in parenthesis
     *         8(0)
     *        /    \
     *       /      \
     *      2(1)     6(2)
     *     /  \      /
     *    4(3) 0(4) 3(5)
     *
     *  after heapify (recursively)
     *  {0, 2, 3, 4, 6, 8}
     *  index is in parenthesis
     *         08(0)
     *        /    \
     *       /      \
     *      6(1)     3(2)
     *     /  \      /
     *    4(3) 2(4) 0(5)
     */

    @Override
    public <T> void sort(Comparator<T> comp, T[] array) {
        heapSize = array.length;
        buildHeap(array, comp);

        T temp;

        // "removal" (*) of the root node until the heap is empty
        // * putting last in the array
        for (int i = array.length - 1; i >= 0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSize--;
            heapify(array, 0, comp);
        }
    }

    private <T> void buildHeap(T[] array, Comparator comp) {
        // Greatest possible node position. Further positions are leaves (no children).
        int startIdx = (heapSize / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            heapify(array, i, comp);
        }
    }

    private <T> void heapify(T[] array, int i, Comparator comp) {
        // assume i is largest
        int node = i;

        // if left child is largest, swap node to left child
        if ((leftChild(i) <= heapSize - 1) && (comp.compare(array[leftChild(i)], array[node]) > 0)) {
            node = leftChild(i);
        }

        // if right child is largest, swap node to left child
        if ((rightChild(i) <= heapSize - 1) && (comp.compare(array[rightChild(i)], array[node]) > 0)) {
            node = rightChild(i);
        }

        // if node is not largest, recursively heapify subtree
        // if node is largest, retrun to next loop in sort()
        if (node != i) {
            T temp = array[i];
            array[i] = array[node];
            array[node] = temp;
            heapify(array, node, comp);
        }
    }

    /**
     * children position in relation to parent
     *           parent(i)
     *         /        \
     *        /          \
     *    left(2*i+1)  right(2*i+2)
     *
     * Example:
     *           parent(3)
     *          /       \
     *         /         \
     *    left(7)    right(8)
     *    (2*3+1)    (2*3+2)
    * */
    private  int leftChild(int i) {
        return (2 * i) + 1;
    }

    private  int rightChild(int i) {
        return (2 * i) + 2;
    }

    /**
     * parents position in relation to child is: (i-1)/2
     *
     * Example:
     *           parent(3)
     *          /       \
     *         /         \
     *    left(7)    right(8)
     *    (7-1)/2    (7-1)/2  (integer division is rounded down)
     * */

    private  int parent(int i) {
        return (i-1)/2;
    }
}
