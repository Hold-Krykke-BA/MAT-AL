package Graphs.interfaces;

public interface GraphBuilder {
    void addEdge(int v1, int v2, float weight);
    Graph build();
}
