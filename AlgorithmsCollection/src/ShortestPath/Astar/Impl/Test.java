package ShortestPath.Astar.Impl;

import Graphs.Directed.Interfaces.DirectedGraph;
import ShortestPath.Astar.Interfaces.AStarProblem;

public class Test
{
    public static void main(String[] args)
    {
        AStarProblem problem = new ManhattanProblem(new ExampleManhattanGraph());
        AStarAlgorithm test = new AStarAlgorithm(problem, 11, 62);
        DirectedGraph g = problem.getGraph();
        System.out.println(test.path(62));
    }
}
