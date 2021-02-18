package com.company;

public class QuickUnion implements UnionFind {
    private int[] id;
    private int count;

    public QuickUnion(int size) {
        this.id = new int[size];
        count = size;
        for (int i = 0; i < size; i++) id[i] = i;
    }

    @Override
    public void union(int p, int q) {

    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
