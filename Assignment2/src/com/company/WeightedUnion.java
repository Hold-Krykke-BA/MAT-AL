package com.company;

public class WeightedUnion implements UnionFind{
    private int[] id;               // parent link
    private int[] size;             // size of component for roots
    private int count;              // number of components


    public WeightedUnion(int n)
    {
        count = n;                  // Initialize count to n
        this.id = new int[n];       // Initialize component id array
        this.size = new int[n];     // Initialize size array
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
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
     * @return the number of sets (between 1 and n)
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
