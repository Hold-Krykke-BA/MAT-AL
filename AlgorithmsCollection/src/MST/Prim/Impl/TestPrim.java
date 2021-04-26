package MST.Prim.Impl;

import Graphs.Undirected.Impl.GraphFactoryImpl;
import Graphs.Undirected.Interfaces.Edge;
import Graphs.Undirected.Interfaces.Graph;
import Graphs.Undirected.Interfaces.GraphFactory;

import java.io.IOException;

public class TestPrim {
    public static void main(String[] args) throws IOException {
        GraphFactory factory = new GraphFactoryImpl();
        Graph graph = factory.readFromFile("F:\\Developer\\Softwareudvikling\\1semester\\OrganisationsRepo\\MAT-AL\\Algorithms\\UndirectedWeightedGraph\\src\\Impl\\graph1.txt");
        System.out.println("Graph from graph1.txt:\n" + graph);
        System.out.println("Prim Result:");

        PrimMSTImpl pmst = new PrimMSTImpl(graph);
        for (Edge e : pmst.edges()){
            System.out.println("weight: " + e.weight());;
        }

        System.out.println("\nHand-tested result of graph1.txt gives:");
        System.out.println("Connection Weight");
        System.out.println("0-2        1.0 \n0-1        2.0 \n0-7        3.0 \n0-4        4.0 \n2-3        6.0 \n3-5        7.0 \n4-6        9.0 \n");

    }
}
