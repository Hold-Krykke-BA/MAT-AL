package solution.sorts;

import java.util.Comparator;

public class HeapSort implements ISortGeneric{
    private int heapSize;
    private int node;
    private int left;
    private int right;

    /**
     * Binary Heap is a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible).
     *
     * Links for readme:
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
     *         0(0)
     *        /    \
     *       /      \
     *      2(1)     3(2)
     *     /  \      /
     *    4(3) 6(4) 8(5)
     */
    
    @Override
    public <T> void sort(Comparator<T> comp, T[] array) {
        heapSize = array.length;
        buildHeap(array, comp);
    }

    private <T> void buildHeap(T[] array, Comparator comp) {
        // Greatest node position. Further positions are leaves (no children).
        int startIdx = (heapSize / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            heapify(array, i, comp);
        }
    }

    private <T> void heapify(T[] array, int i, Comparator comp) {
    }

    private  int getLeft(int i) {
        return 0;
    }

    private  int getRight(int i) {
        return 0;
    }

    private  int getParent(int i) {
        return 0;
    }

    @Override
    public <T> boolean isSorted(Comparator<T> comp, T[] array) {
        return false;
    }
}
