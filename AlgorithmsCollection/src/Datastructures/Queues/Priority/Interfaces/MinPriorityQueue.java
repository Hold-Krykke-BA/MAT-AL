package Datastructures.Queues.Priority.Interfaces;

/**
 * https://algs4.cs.princeton.edu/24pq/MinPQ.java.html
 * https://algs4.cs.princeton.edu/24pq/
 */
public interface MinPriorityQueue<T> {
    /**
     * Checks if PQ is empty or not
     *
     * @return true if priority queue is empty; otherwise false.
     */
    boolean isEmpty();

    /**
     * Size of the PQ
     *
     * @return the number of keys in the priority queue.
     */
    int size();

    /**
     * Minimum key according to the PQ comparator
     *
     * @return the minimum key in the priority queue
     */
    T min();

    /**
     * Adds a item to the PQ
     *
     * @param item item to add
     */
    void insert(T item);

    /**
     * Removes and returns the smallest key on the PQ
     *
     * @return the deleted key
     */
    T delMin();

    /**
     * Also known as Bottom-up reheapify.
     *
     * If in a max-heap one of the nodes is
     * greater than its parent, it switches
     * places with the parent, and repeats this
     * until it is not greater than its parent.
     *
     * @param key
     */
    void swim(int key);

    /**
     * Also known as Top-down heapify.
     *
     * If in a max-heap one of the nodes is smaller than
     * one or both of its children, it switches places with
     * the larger one of the two children, and repeats
     * this until all its children are smaller than itself.
     *
     * @param key
     */
    void sink(int key);

}
