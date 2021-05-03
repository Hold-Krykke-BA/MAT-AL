package ShortestPath.Astar.Impl;

import Graphs.Directed.Interfaces.DirectedGraph;
import ShortestPath.Astar.Interfaces.AStarProblem;

public class Test
{
    public static void main(String[] args)
    {
        AStarProblem problem = new ManhattanProblem(new ExampleManhattanGraph());
        DirectedGraph g = problem.getGraph();
        System.out.println(g);
    }
}
