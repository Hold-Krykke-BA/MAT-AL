package Graphs.Directed.Impl;

import Graphs.Directed.Interfaces.DirectedGraph;
import Graphs.Directed.Interfaces.DirectedGraphFactory;
import ShortestPath.Dijkstra.Impl.SpDijkstraImpl;

import java.io.IOException;
import java.util.ArrayList;

public class TestDirected {
    public static void main(String[] args) throws IOException {
        DirectedGraphFactory factory = new DirectedGraphFactoryImpl();
        DirectedGraph graph = factory.readFromFile("src/Textfiles/graph2.txt");
        System.out.println(graph);
        SpDijkstraImpl dijkstra = new SpDijkstraImpl(graph, 0);
        System.out.println(dijkstra);
        System.out.println(dijkstra.path(7, new ArrayList<>()));
    }

}
