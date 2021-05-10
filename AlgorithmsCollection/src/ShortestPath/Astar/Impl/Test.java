package ShortestPath.Astar.Impl;

import Graphs.Directed.Interfaces.DirectedGraph;
import ShortestPath.Astar.Interfaces.AStarProblem;
import ShortestPath.Astar.util.GraphFromFile;

import java.io.IOException;

public class Test
{
    public static void main(String[] args) throws IOException {
        GraphFromFile gff = new GraphFromFile();
        //int[][] map = gff.read("src/ShortestPath/Astar/util/ProblemA.txt", 25, 25);
        //AStarProblem problem = new ManhattanProblem(new Problem("src/ShortestPath/Astar/util/ProblemA.txt", 25, 25));

        //AStarProblem problem = new ManhattanProblem(new ExampleManhattanGraph());
        //AStarAlgorithm test = new AStarAlgorithm(problem, 490, 23);
        //DirectedGraph g = problem.getGraph();
        //System.out.println(test.path(23));

        //Problem B
        int[][] map = gff.read("src/ShortestPath/Astar/util/ProblemB.txt", 25, 25);
        AStarProblem problem = new ManhattanProblem(new Problem("src/ShortestPath/Astar/util/ProblemB.txt", 25, 25));
        AStarAlgorithm test = new AStarAlgorithm(problem, 435, 23); //88 -> 142 =!
        DirectedGraph g = problem.getGraph();
        System.out.println(test.path(23));
    }
}
