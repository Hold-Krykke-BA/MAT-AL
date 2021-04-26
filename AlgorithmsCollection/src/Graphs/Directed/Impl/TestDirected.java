package Graphs.Directed.Impl;

import Graphs.Directed.Interfaces.DirectedGraph;
import Graphs.Directed.Interfaces.DirectedGraphFactory;

import java.io.IOException;

public class TestDirected {
    public static void main(String[] args) throws IOException {
        DirectedGraphFactory factory = new DirectedGraphFactoryImpl();
        DirectedGraph graph = factory.readFromFile("src/Textfiles/graph2.txt");
        System.out.println(graph);
    }

}
