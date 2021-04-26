package Graphs.Directed.Interfaces;

import java.io.IOException;

public interface DirectedGraphFactory {
    DirectedGraphBuilder getNewBuilder(int verticeCount);
    DirectedGraph readFromFile(String fileName) throws IOException;
}
