package Graphs.Impl;


import Graphs.interfaces.Graph;
import Graphs.interfaces.GraphFactory;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        GraphFactory factory = new GraphFactoryImpl();
        Graph graph = factory.readFromFile("F:\\Developer\\Softwareudvikling\\1semester\\OrganisationsRepo\\MAT-AL\\AlgorithmsCollection\\src\\Graphs\\Impl\\graph1.txt");
        System.out.println(graph);
    }
}
