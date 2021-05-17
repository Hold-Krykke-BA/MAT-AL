package Part1.interfaces;

public interface DirectedGraphBuilder {
    void addEdge(int v1, int v2, float weight);
    Graph build();
}
