package Graphs.Directed.Interfaces;

public interface DirectedGraphBuilder {
    void addEdge(int v1, int v2, float weight);
    DirectedGraph build();
}
