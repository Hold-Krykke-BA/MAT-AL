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
    public int count() {
        return 0;
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }
}
