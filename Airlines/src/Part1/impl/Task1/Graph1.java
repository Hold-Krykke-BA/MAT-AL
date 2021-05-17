package Part1.impl.Task1;

import java.util.ArrayList;
import java.util.HashMap;


public class Graph1 implements IGraph1, IGraphBuilder1 {

    HashMap<String, ArrayList<IEdge1>> verticesMap;
    ArrayList<IEdge1> allEdges;

    public Graph1() {
        this.allEdges = new ArrayList<>();
        this.verticesMap = new HashMap<>();
    }

    @Override
    public int V() {
        return verticesMap.size();
    }

    @Override
    public int E() {
        return allEdges.size();
    }

    @Override
    public Iterable<IEdge1> adj(String v) {
        ArrayList<IEdge1> adjList = verticesMap.get(v);
        if (adjList == null) {
            adjList = new ArrayList<>();
        }
        return adjList;
    }

    @Override
    public Iterable<IEdge1> edges() {
        return allEdges;
    }

    @Override
    public void addEdge(String v1, String v2, float weight) {
        IEdge1 e = new Edge1(v1, v2, weight);
        allEdges.add(e);
        addEdgeToList(v1, e);
        addEdgeToList(v2, e);
    }

    private void addEdgeToList(String v, IEdge1 e) {
        ArrayList<IEdge1> edge = verticesMap.get(v);
        if (edge == null) {
            verticesMap.put(v, new ArrayList<IEdge1>());
        }
        verticesMap.get(v).add(e);
    }

    @Override
    public IGraph1 build() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(V());
        res.append('\n');
        res.append(E());
        res.append('\n');
        for(IEdge1 e : edges()) {
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
