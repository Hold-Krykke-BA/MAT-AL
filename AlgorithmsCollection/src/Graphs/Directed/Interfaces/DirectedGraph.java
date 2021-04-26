package Graphs.Directed.Interfaces;

public interface DirectedGraph {
    int V(); //vertex
    int E(); //edge
    Iterable<DirectedEdge> adj(int v);
    Iterable<DirectedEdge> edges();
}
