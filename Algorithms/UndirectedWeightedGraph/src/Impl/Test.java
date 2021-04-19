package Impl;

import interfaces.Graph;
import interfaces.GraphFactory;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        GraphFactory factory = new GraphFactoryImpl();
        Graph graph = factory.readFromFile("src/Impl/graph1.txt");
        System.out.println(graph);
    }
}
