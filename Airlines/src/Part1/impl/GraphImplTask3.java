package Part1.impl;

import Part1.impl.Task3.EdgeImplTask3;
import Part1.impl.Task3.EdgeTask3;
import Part1.impl.Task3.GraphBuilderTask3;
import Part1.impl.Task3.GraphTask3;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphImplTask3 implements GraphTask3, GraphBuilderTask3 {

    HashMap<String, ArrayList<EdgeTask3>> map;
    ArrayList<EdgeTask3> allEdges;

    public GraphImplTask3() {
        this.map = new HashMap();
        this.allEdges = new ArrayList<>();
    }

    @Override
    public int V() {
        return map.size();
    }

    @Override
    public int E() {
        return allEdges.size();
    }

    @Override
    public Iterable<EdgeTask3> adj(String v) {
        ArrayList<EdgeTask3> adjList = map.get(v);
        if (adjList == null) {
            adjList = new ArrayList<>();
        }
        return adjList;
    }

    @Override
    public Iterable<EdgeTask3> edges() {
        return allEdges;
    }

    @Override
    public void addEdge(String v1, String v2, float weight) {
        EdgeTask3 e = new EdgeImplTask3(v1, v2, weight);
        allEdges.add(e);
        addEdgeToList(v1, e);
        addEdgeToList(v2, e);
    }

    private void addEdgeToList(String v, EdgeTask3 e) {
        ArrayList<EdgeTask3> edgeTask3 = map.get(v);
        if (edgeTask3 == null) {
            map.put(v, new ArrayList<EdgeTask3>());
        }
        map.get(v).add(e);
    }

    @Override
    public GraphTask3 build() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(V());
        res.append('\n');
        res.append(E());
        res.append('\n');
        for(EdgeTask3 e : edges()) {
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
