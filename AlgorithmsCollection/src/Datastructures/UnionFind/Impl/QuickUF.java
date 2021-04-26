package Datastructures.UnionFind.Impl;

import Datastructures.UnionFind.Interfaces.UnionFind;

/**
 * Quick Union Find implementation using Integer and array (as in the book)
 */
public class QuickUF implements UnionFind<Integer> {
    private Integer[] id;  // access to component id
    private int count; // number of components

    /**
     * Initializes an empty union-find data structure with
     * n amount of elements. Initially, each element is in its own set.
     *
     * @param n the number of elements
     */
    public QuickUF(int n) {
        this.id = new Integer[n];    // Initialize component id array
        count = n;               // Initialize count to n
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    /**
     * Merges the set containing element p with the set containing element q
     *
     * Follow links to find the roots associated with p and q,
     * then rename one of the components by linking one of these
     * roots to the other
     * @param  p one element
     * @param  q the other element
     */
    public void union(Integer p, Integer q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot == qRoot) return; // if(connected(p, q)) return;
        id[pRoot] = qRoot;
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
