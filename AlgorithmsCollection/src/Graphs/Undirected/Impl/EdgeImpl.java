package Graphs.Undirected.Impl;

import Graphs.Undirected.Interfaces.Edge;

public class EdgeImpl implements Edge {

    private int a, b; //vertex left, right
    private float w; //weight

    public EdgeImpl(int a, int b, float w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int either() {
        return a;
    }

    @Override
    public int other(int v) {
        if (v==a) return b;
        if (v==b) return a;
        throw new RuntimeException("Input " + v + " doesn't match " + this);
    }

    @Override
    public float weight() {
        return w;
    }

    @Override
    public int compareTo(Edge o) {
        //this.compareTo(other) < 0 if this < other
        //this.compareTo(other) = 0 if this == other
        //this.compareTo(other) > 0 if this > other
        //if(this.w < o.getWeight()) return ...
        //TOG's way:
        float f = this.w - o.weight();
        if (f > 0) return 1;
        if (f < 0) return -1;
        return 0;
    }
}
