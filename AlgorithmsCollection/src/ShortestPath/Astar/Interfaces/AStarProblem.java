package ShortestPath.Astar.Interfaces;

import Graphs.Directed.Interfaces.DirectedGraph;

public interface AStarProblem {
    DirectedGraph getGraph();
    int getStartNode();
    int getTargetNode();
    Heuristic getHeuristic();
}
