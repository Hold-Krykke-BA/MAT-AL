package ShortestPath.Astar.Impl;

import Graphs.Directed.Interfaces.DirectedGraph;
import ShortestPath.Astar.Interfaces.AStarProblem;
import ShortestPath.Astar.Interfaces.Heuristic;

public class AStarAlgorithm {
    private DirectedGraph graph;
    private int startNode;
    private int targetNode;
    private Heuristic heuristic;

    public AStarAlgorithm(AStarProblem problem) {
        this.graph = problem.getGraph();
        this.startNode = problem.getStartNode();
        this.targetNode = problem.getTargetNode();
        this.heuristic = problem.getHeuristic();
    }
}
