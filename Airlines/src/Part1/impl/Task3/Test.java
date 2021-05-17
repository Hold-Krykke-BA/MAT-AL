package Part1.impl.Task3;

import Part1.impl.DijkstraImpl;
import Part1.impl.DirectedGraph;
import Part1.impl.GraphImplTask3;
import Part1.impl.Routes;
import Part1.interfaces.DirectedGraphBuilder;
import Part1.interfaces.Graph;
import Part1.utils.ReadCSVFromFile;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        ReadCSVFromFile rsv = new ReadCSVFromFile();
        List<Routes> routes = rsv.readRoutes("src/Part1/data/routes.txt", ";");

        GraphBuilderTask3 builder = new GraphImplTask3();
        for (int i = 0; i < routes.size(); i++) {
            String v1 = routes.get(i).getSourceCode();
            String v2 = routes.get(i).getDestinationCode();
            float weight = Float.parseFloat(routes.get(i).getTime());
            builder.addEdge(v1,v2,weight);
        }

        GraphTask3 graph = builder.build();

        DijkstraImplTask3 dijkstra = new DijkstraImplTask3(graph, "OSS");
        System.out.println(dijkstra);
        System.out.println(dijkstra.path("SCN"));
    }
}
