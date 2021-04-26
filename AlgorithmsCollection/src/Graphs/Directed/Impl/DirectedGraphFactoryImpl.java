package Graphs.Directed.Impl;

import Graphs.Directed.Interfaces.DirectedGraph;
import Graphs.Directed.Interfaces.DirectedGraphBuilder;
import Graphs.Directed.Interfaces.DirectedGraphFactory;

import java.io.*;

public class DirectedGraphFactoryImpl implements DirectedGraphFactory {
    @Override
    public DirectedGraphBuilder getNewBuilder(int verticeCount) {
        return new DirectedGraphImpl(verticeCount);
    }

    @Override
    public DirectedGraph readFromFile(String fileName) throws IOException {
        InputStream in = new FileInputStream(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line = br.readLine();
            int v = Integer.parseInt(line); //vertices
            DirectedGraphBuilder builder = getNewBuilder(v);
            line = br.readLine(); //edges
            int edges = Integer.parseInt(line);
            for (int i = 0; i < edges; i++) {
                line = br.readLine();
                String[] vertrices = line.split(" ");
                int v1 = Integer.parseInt(vertrices[0]);
                int v2 = Integer.parseInt(vertrices[1]);
                float weight = Float.parseFloat(vertrices[2]);
                builder.addEdge(v1,v2,weight);
            }
            return builder.build();
        }
    }
}
