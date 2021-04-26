package Datastructures.UnionFind.Impl;

import Datastructures.UnionFind.Interfaces.UnionFind;

/**
 * Weighted Union Find implementation using Integer and array (as in the book), but using Path Compression ("PC").
 * <p>
 * PC is discussed in the book but not done in detail.
 * <p>
 * Notable changes are to be found in the findRoot() method.
 * <p>
 * https://www.youtube.com/watch?t=185&v=KbFlZYCpONw&feature=youtu.be
 *
 * @see {@link #findRoot(int)}
 */
public class WeightedUFWithPC implements UnionFind<Integer> {
    private final Integer[] id; // parent link
    private final int[] size; // size of component for roots
    private int count; // number of components

    /**
     * Initializes an empty union-find data structure with
     * n amount of elements. Initially, each element is in its own set
     * and is its own size.
     *
     * @param n the number of elements
     */
    public WeightedUFWithPC(int n) {
        count = n;                          // Initialize count to n
        this.id = new Integer[n];               // Initialize component id array
        this.size = new int[n];             // Initialize size array
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
    public int count() {
        return count;
    }

    @Override
    /**
     * Start at p, follow its link to another site and so
     * forth until reaching a site that has a link to itself (root)
     *
     * Afterwards, compress the node links so that all point to the same root. ("Path Compression")
     * @param  p an element
     * @return root of p
     */
    public Integer findRoot(Integer p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        //Compress the path leading back to the root
        //We still have p (starting point) and now also actual root!
        //This is done every time we use union, so we can constantly optimize the tree
        while (p != root) { //traverse from starting point p to root
            int next = id[p]; //save original next node pointer
            id[p] = root; //point element to root rather than next node
            p = next;
        }
        return root;
    }
}
