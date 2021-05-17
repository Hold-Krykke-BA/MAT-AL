package Part1.impl.Task2;

import Part1.impl.GraphImplTask3;
import Part1.impl.Routes;
import Part1.impl.Task3.GraphBuilderTask3;
import Part1.impl.Task3.GraphTask3;
import Part1.utils.ReadCSVFromFile;

import java.io.IOException;
import java.util.List;

/**
 * Finding shortest path (distance) from one location to another (Dijkstra’s algorithm)
 */
public class Task2 {

    public static void main(String[] args) throws IOException {
        ReadCSVFromFile rsv = new ReadCSVFromFile();
        List<Routes> routes = rsv.readRoutes("src/Part1/data/routes.txt", ";");

        GraphBuilderTask3 builder = new GraphImplTask3();
        for (int i = 0; i < routes.size(); i++) {
            String v1 = routes.get(i).getSourceCode();
            String v2 = routes.get(i).getDestinationCode();
            float weight = Float.parseFloat(routes.get(i).getDistance()); //we are interested in distance for this shortest path algorithm
            builder.addEdge(v1, v2, weight);
        }

        GraphTask3 graph = builder.build();

        DijkstraImplTask2 dijkstra = new DijkstraImplTask2(graph, "OSS");
        System.out.println(dijkstra);
        System.out.println(dijkstra.path("SCN"));

        Float pathSize = 0F;
        for (int i = dijkstra.shortestPathArr.size() - 1; i > 0; i--) {
            int index = routes.indexOf(new Routes("", dijkstra.shortestPathArr.get(i), dijkstra.shortestPathArr.get(i - 1), "", ""));
            Routes roi = routes.get(index);
            System.out.print(roi.getDistance() + " -> ");
            pathSize += Float.valueOf(roi.getDistance());
        }
        System.out.println("\nTotal length: " + pathSize);
    }
}
