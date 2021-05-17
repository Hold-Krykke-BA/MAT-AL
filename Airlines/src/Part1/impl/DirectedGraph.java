package Part1.impl;

import Part1.interfaces.DirectedGraphBuilder;
import Part1.interfaces.Edge;
import Part1.interfaces.Graph;

import java.util.ArrayList;

public class DirectedGraph implements Graph, DirectedGraphBuilder {

    ArrayList<Edge>[] array;
    ArrayList<Edge> allEdges;

    public DirectedGraph(int verticeCount) {
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
