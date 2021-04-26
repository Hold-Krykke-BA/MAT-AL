package Datastructures.Queues.Priority.Impl;

import Datastructures.Queues.Priority.Interfaces.MinPriorityQueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * https://algs4.cs.princeton.edu/24pq/MinPQ.java.html
 * https://algs4.cs.princeton.edu/24pq/
 * <p>
 * Generic min priority queue implementation with a binary heap.
 * Can be used with a comparator instead of the natural order.
 * <p>
 * Can be optimized by replacing full exchanges with half exchanges
 * (ala insertion sort).
 */
public class MinPriorityQueueImpl<T> implements MinPriorityQueue<T>, Iterable<T> {
    private T[] pq;                    // store items at indices 1 to n
    private int n;                     // number of items on priority queue
    private Comparator<T> comparator;  // optional comparator

    //<editor-fold desc="<--Folded constructors-->">

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param initCapacity the initial capacity of this priority queue
     */
    public MinPriorityQueueImpl(int initCapacity) {
        pq = (T[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MinPriorityQueueImpl() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param initCapacity the initial capacity of this priority queue
     * @param comparator   the order in which to compare the keys
     */
    public MinPriorityQueueImpl(int initCapacity, Comparator<T> comparator) {
        this.comparator = comparator;
        pq = (T[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param comparator the order in which to compare the keys
     */
    public MinPriorityQueueImpl(Comparator<T> comparator) {
        this(1, comparator);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * <p>
     * Takes time proportional to the number of keys, using sink-based heap construction.
     *
     * @param keys the array of keys
     */
    public MinPriorityQueueImpl(T[] keys) {
        n = keys.length;
        pq = (T[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i + 1] = keys[i];
        for (int k = n / 2; k >= 1; k--)
            sink(k);
        //assert isMinHeap(); //from book
    }
    //</editor-fold>

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public T min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow"); //return null;
        return pq[1]; //binary heap procedure means lowest value will be in pq[1]. https://stackoverflow.com/a/3609438/14234578
    }

    @Override
    public void insert(T item) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and swim it up to maintain heap invariant
        pq[++n] = item;
        swim(n);
        //assert isMinHeap(); //from book
    }

    @Override
    public T delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        T min = pq[1];
        exchange(1, n--);   //swap min with last
        sink(1);          //sink new min
        pq[n + 1] = null;     //help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4))
            resize(pq.length / 2); //if size is reduced substantially, reduce size by half
        //assert isMinHeap(); //from book
        return min;
    }

    @Override
    public void swim(int key) {
        //todo add a few lines here or in interface
        while (key > 1 && greater(key / 2, key)) { //while pq[key/2] > pg[key]
            exchange(key, key / 2); //swap their values
            key = key / 2; //change for next iteration
        }
    }

    @Override
    public void sink(int key) {
        //todo add a few lines here or in interface
        while (2 * key <= n) { //while (key * 2) <= pq size
            int j = 2 * key; //idx for (key *2 )
            if (j < n && greater(j, j + 1)) j++; //if (j+1) > j
            if (!greater(key, j)) break; //not sure how this would be hit
            exchange(key, j); //swap
            key = j; //change for next iteration
        }
    }

    /*----HELPER METHODS----*/

    /**
     * resize the underlying array to have the given capacity
     */
    private void resize(int capacity) {
        if (capacity <= n) throw new IllegalArgumentException("Capacity must not be lower than current size.");
        T[] temp = (T[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Checks if pq[val1] is greater than pq[val2].
     * <p>
     * Uses comparator if available, otherwise attempts to incur Comparable.
     * <p>
     * greater(1, 2) >>> false
     * greater(2, 1) >>> true
     *
     * @param i Value one
     * @param j Value two
     * @return i > j
     */
    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<T>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    /**
     * Exchanges two values spots in the pq
     *
     * @param i index of value one
     * @param j index of value two
     */
    private void exchange(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    //<editor-fold desc="<--Unused isMinHeap()-->">

    /**
     * is pq[1..n] a min heap?
     * (Used in book for assertion testing; unused here)
     *
     * @return true if is a min heap
     */
    private boolean isMinHeap() {
        for (int i = 1; i <= n; i++) {
            if (pq[i] == null) return false;
        }
        for (int i = n + 1; i < pq.length; i++) {
            if (pq[i] != null) return false;
        }
        if (pq[0] != null) return false;
        return isMinHeapOrdered(1);
    }

    /**
     * is subtree of pq[1..n] rooted at k a min heap?
     * (Used in book for assertion testing; unused here)
     *
     * @param k
     * @return true if the min heap is ordered
     */
    private boolean isMinHeapOrdered(int k) {
        if (k > n) return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= n && greater(k, left)) return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeapOrdered(left) && isMinHeapOrdered(right);
    }
    //</editor-fold>

    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in ascending order.
     * <p>
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<T> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<T> {
        // create a new pq
        MinPriorityQueue<T> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) copy = new MinPriorityQueueImpl<T>(size());
            else copy = new MinPriorityQueueImpl<T>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public MinPriorityQueueImpl<T> getCopy() {
            return (MinPriorityQueueImpl<T>) copy;
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            //todo
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}
