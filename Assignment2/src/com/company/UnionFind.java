package com.company;

public interface UnionFind {
    void union(int p, int q);                   // add connection between p and q
    int count();                                // number of components/sets
    int find(int p);                            // component identifier for p ( given point p, return set of p)
    boolean connected(int p, int q);            // return true if p and q are in the same component/set
}
