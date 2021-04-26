package Graphs.Undirected.Impl;


import Graphs.Undirected.Interfaces.Edge;
import Graphs.Undirected.Interfaces.Graph;
import Graphs.Undirected.Interfaces.GraphBuilder;

import java.util.ArrayList;

public class GraphImpl implements Graph, GraphBuilder {
    ArrayList<Edge>[] array;
    ArrayList<Edge> allEdges;

    public GraphImpl(int verticeCount) {
        this.array = new ArrayList[verticeCount];
        this.allEdges = new ArrayList<>();
    }

    @Override
    public int V() {
        return array.length;
    }

    @Override
    public int E() {
        return allEdges.size();
    }

    @Override
    public Iterable<Edge> adj(int v) {
        ArrayList<Edge> adjList = array[v];
        if (adjList == null) {
            adjList = new ArrayList<>();
        }
        return adjList;
    }

    @Override
    public Iterable<Edge> edges() {
        return allEdges;
    }

    @Override
    public void addEdge(int v1, int v2, float weight) {
        Edge e = new EdgeImpl(v1, v2, weight);
        allEdges.add(e);
        addEdgeToList(v1, e);
        addEdgeToList(v2, e);
    }

    private void addEdgeToList(int v, Edge e) {
        ArrayList<Edge> list = array[v];
        if (list == null) {
            list = new ArrayList<>();
            array[v] = list;
        }
        list.add(e);
    }

    @Override
    public Graph build() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(V());
        res.append('\n');
        res.append(E());
        res.append('\n');
        for(Edge e : edges()) {
            res.append(e.either());
            res.append(' ');
            res.append(e.other(e.either()));
            res.append(' ');
            res.append(e.weight());
            res.append('\n');
        }
        return res.toString();
    }
}
