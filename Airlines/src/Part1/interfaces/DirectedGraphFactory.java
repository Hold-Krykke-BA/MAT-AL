package Part1.interfaces;

import java.io.IOException;

public interface DirectedGraphFactory {
    DirectedGraphBuilder getNewBuilder(int verticeCount);

    Graph readFromFile(String fileName) throws IOException;
}
