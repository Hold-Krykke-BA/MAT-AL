package Graphs.Undirected.interfaces;

import java.io.IOException;

public interface GraphFactory {
    GraphBuilder getNewBuilder(int verticeCount);
    Graph readFromFile(String fileName) throws IOException;
}
