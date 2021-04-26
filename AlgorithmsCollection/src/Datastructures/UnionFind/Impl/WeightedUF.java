package Datastructures.UnionFind.Impl;

import Datastructures.UnionFind.Interfaces.UnionFind;

/**
 * Weighted Union Find implementation using Integer and array (as in the book)
 * <p>
 * Note the size array, how it is initialized and how line 44-50 is the difference from QuickUF.
 */
public class WeightedUF implements UnionFind<Integer> {
    private final Integer[] id; // parent link
    private int[] size; // size of component for roots
    private int count; // number of components

    /**
     * Initializes an empty union-find data structure with
     * n amount of elements. Initially, each element is in its own set
     * and is its own size.
     *
     * @param n the number of elements
     */
    public WeightedUF(int n) {
        count = n; // Initialize count to n
        this.id = new Integer[n]; // Initialize component id array
        this.size = new int[n]; // Initialize size array
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            id[i] = i;
        }
    }

    @Override
    /**
     * Merges the set containing element p with the set containing element q
     * Make root of smaller tree point to root of larger tree.
     * @param  p one element
     * @param  q the other element
     */
    public void union(Integer p, Integer q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot == qRoot) return;         // if(connected(p, q)) return;

        if (size[pRoot] < size[qRoot]) {    // root of p is smaller than root of q
            id[pRoot] = qRoot;              // point root of p to root of q
            size[qRoot] += size[pRoot];     // size/weight of q is incremented with size/weight of p
        } else {                            // root of p is greater or equal root of q
            id[qRoot] = pRoot;              // point root of q to root of p
            size[pRoot] += size[qRoot];     // size/weight of p is incremented with size/weight of q
        }
        count--;
    }

    @Override
    /**
     * @return the number of sets (between 1 and n)
     */
    public int count() {
        return count;
    }

    @Override
    /**
     * Start at p, follow its link to another site and so
     * forth until reaching a site that has a link to itself (root)
     * @param  p an element
     * @return root of p
     */
    public Integer findRoot(Integer p) {
        while (p != id[p]) {
            p = id[p]; //change pointer, loop iterates
        }
        return p;
    }
}
