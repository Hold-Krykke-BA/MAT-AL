package Graphs.Undirected.Interfaces;

public interface Graph {
    int V(); //vertex
    int E(); //edge
    Iterable<Edge> adj(int v);
    Iterable<Edge> edges();
}
