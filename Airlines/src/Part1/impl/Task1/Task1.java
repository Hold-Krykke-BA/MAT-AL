package Part1.impl.Task1;

import Part1.impl.*;
import Part1.utils.ReadCSVFromFile;
import java.io.IOException;
import java.util.List;

/*
   1. Find if an airport can be reached from another, using only a single airline
   company. You should compare Breath-First and Depth-First approaches.
*/
public class Task1 {
    public static void main(String[] args) throws IOException {

        ReadCSVFromFile rsv = new ReadCSVFromFile();
        List<Routes> routes = rsv.readRoutes("src/Part1/data/routes.txt", ";");

        IGraphBuilder1 builder = new Graph1();
        for (Routes route : routes) {
            String v1 = route.getSourceCode();
            String v2 = route.getDestinationCode();

            builder.addEdge(v1, v2, route.getAirlineCode());
        }

        IGraph1 graph = builder.build();
//        System.out.println(graph.toString());

        BreadthFirst bfs = new BreadthFirst(graph);
        DepthFirst dfs = new DepthFirst(graph);
        System.out.println("BFS has found a connection AER-PEM with 2B: " + bfs.hasConnection("AER", "PEM", "2B") + "\n");
        System.out.println("DFS has found a connection AER-PEM with 2B: " + dfs.hasConnection("AER", "PEM", "2B")+ "\n\n\n");

        BreadthFirst bfs2 = new BreadthFirst(graph);
        DepthFirst dfs2 = new DepthFirst(graph);
        System.out.println("BFS2 has found a connection AER-SVX with 2B: " + bfs2.hasConnection("AER", "SVX", "2B") + "\n");
        System.out.println("DFS2 has found a connection AER-SVX with 2B: " + dfs2.hasConnection("AER", "SVX", "2B"));




    }
}
