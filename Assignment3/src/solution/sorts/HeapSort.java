package solution.sorts;

import java.util.Comparator;

public class HeapSort implements ISortGeneric{
    private int heapSize;
    private int node;
    private int left;
    private int right;

    // unsorted
    // {8, 2, 6, 4, 0, 3}
    // index is in parenthesis
    //        8(0)
    //       /    \
    //      /      \
    //     2(1)     6(2)
    //    /  \      /
    //   4(3) 0(4) 3(5)
    //
    // sorted
    // {0, 2, 3, 4, 6, 8}
    // index is in parenthesis
    //        0(0)
    //       /    \
    //      /      \
    //     2(1)     3(2)
    //    /  \      /
    //   4(3) 6(4) 8(5)

    @Override
    public <T> void sort(Comparator<T> comp, T[] array) {

    }

    private void buildHeap(int[] array, Comparator comp) {
        heapSize = array.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(array, i, comp);
        }
    }

    private void heapify(int[] array, int i, Comparator comp) {
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
