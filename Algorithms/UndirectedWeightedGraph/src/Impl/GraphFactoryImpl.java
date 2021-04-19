package Impl;

import interfaces.Graph;
import interfaces.GraphBuilder;
import interfaces.GraphFactory;

import java.io.*;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public GraphBuilder getNewBuilder(int verticeCount) {
        return new GraphImpl(verticeCount);
    }

    @Override
    public Graph readFromFile(String fileName) throws IOException {
        InputStream in = new FileInputStream(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line = br.readLine();
            int v = Integer.parseInt(line); //vertices
            GraphBuilder builder = getNewBuilder(v);
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
