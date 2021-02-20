package com.company;

public class QuickUnion implements UnionFind {
    private int[] id;               // access to component id (site indexed)
    private int count;              // number of components

    public QuickUnion(int size) {
        this.id = new int[size];    // Initialize component id array
        count = size;               // Initialize count to size
        for (int i = 0; i < size; i++) {
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
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return; //if(connected(p, q)) return;
        id[pRoot] = qRoot;
        count--;
    }

    @Override
    /**
     * start at p, follow its link to another site and so
     * forth until reaching a site that has a link to itself (root)
     * @param  p an element
     * @return root of p
     */
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    /**
     * @return the number of sets (between 1 and size)
     */
    public int count() {
        return count;
    }

    @Override
    /**
     * @param  p one element
     * @param  q the other element
     * @return true if p and q are in the same set else false.
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
