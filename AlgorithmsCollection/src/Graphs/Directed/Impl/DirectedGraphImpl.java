package Graphs.Directed.Impl;

import Graphs.Directed.Interfaces.DirectedEdge;
import Graphs.Directed.Interfaces.DirectedGraph;
import Graphs.Directed.Interfaces.DirectedGraphBuilder;

import java.util.ArrayList;

public class DirectedGraphImpl implements DirectedGraph, DirectedGraphBuilder {
    ArrayList<DirectedEdge>[] array;
    ArrayList<DirectedEdge> allEdges;

    public DirectedGraphImpl(int verticeCount) {
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
    public Iterable<DirectedEdge> adj(int v) {
        ArrayList<DirectedEdge> adjList = array[v];
        if (adjList == null) {
            adjList = new ArrayList<>();
        }
        return adjList;
    }

    @Override
    public Iterable<DirectedEdge> edges() {
        return allEdges;
    }

    @Override
    public void addEdge(int v1, int v2, float weight) {
        DirectedEdge e = new DirectedEdgeImpl(v1, v2, weight);
        allEdges.add(e);
        addEdgeToList(v1, e);
        addEdgeToList(v2, e);
    }

    private void addEdgeToList(int v, DirectedEdge e) {
        ArrayList<DirectedEdge> list = array[v];
        if (list == null) {
            list = new ArrayList<>();
            array[v] = list;
        }
        list.add(e);
    }

    @Override
    public DirectedGraph build() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(V());
        res.append('\n');
        res.append(E());
        res.append('\n');
        for(DirectedEdge e : edges()) {
            res.append(e.from());
            res.append(' ');
            res.append(e.to());
            res.append(' ');
            res.append(e.weight());
            res.append('\n');
        }
        return res.toString();
    }
}
