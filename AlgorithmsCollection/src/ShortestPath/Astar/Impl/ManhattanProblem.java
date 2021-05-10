package ShortestPath.Astar.Impl;

import Graphs.Directed.Impl.DirectedGraphFactoryImpl;
import Graphs.Directed.Interfaces.DirectedGraph;
import Graphs.Directed.Interfaces.DirectedGraphBuilder;
import Graphs.Directed.Interfaces.DirectedGraphFactory;
import ShortestPath.Astar.Interfaces.AStarProblem;
import ShortestPath.Astar.Interfaces.Heuristic;
import ShortestPath.Astar.Interfaces.ManhattanGraph;

import java.util.HashMap;
import java.util.Map;

public class ManhattanProblem implements AStarProblem, Heuristic
{
    private ManhattanGraph mg;
    private DirectedGraph graph;
    private Node[] nodes;
    private int startNode;
    private int targetNode;

    public ManhattanProblem(ManhattanGraph mg)
    {
        Map<Node, Integer> nodeMap = new HashMap<>();
        this.mg = mg;
        int nodeCount = 0;
        startNode = -1;
        targetNode = -1;
        for (int y = 0; y < mg.height(); ++y)
        {
            for (int x = 0; x < mg.width(); ++x)
            {
                switch (mg.get(x, y))
                {
                    case ManhattanGraph.EMPTY:
                        ++nodeCount;
                        break;
                    case ManhattanGraph.START:
                        if (startNode != -1)
                        {
                            throw new RuntimeException("There can be only one startNode node!");
                        }
                        startNode = nodeCount++;
                        break;
                    case ManhattanGraph.TARGET:
                        if (targetNode != -1)
                        {
                            throw new RuntimeException("There can be only one targetNode node!");
                        }
                        targetNode = nodeCount++;
                        break;
                    case ManhattanGraph.WALL:
                        break;
                    default:
                        throw new RuntimeException("Unknown value: " + mg.get(x, y));
                }

            }
        }
        if (startNode == -1)
        {
            throw new RuntimeException("There is no startNode node");
        }
        if (targetNode == -1)
        {
            throw new RuntimeException("There is no targetNode node");
        }
        nodes = new Node[nodeCount];
        nodeCount = 0;
        for (int y = 0; y < mg.height(); ++y)
        {
            for (int x = 0; x < mg.width(); ++x)
            {
                switch (mg.get(x, y))
                {
                    case ManhattanGraph.EMPTY:
                    case ManhattanGraph.START:
                    case ManhattanGraph.TARGET:
                        nodes[nodeCount] = new Node(x, y);
                        nodeMap.put(nodes[nodeCount],nodeCount);
                        ++nodeCount;
                        break;
                }

            }
        }

        //Build the graph
        DirectedGraphBuilder gb = new DirectedGraphFactoryImpl().getNewBuilder(nodes.length);
        for (int y = 0; y < mg.height(); ++y)
        {
            for (int x = 0; x < mg.width(); ++x)
            {
                if (mg.get(x, y) != ManhattanGraph.WALL)
                {
                    int v1 = nodeMap.get(new Node(x, y));
                    //Left
                    if (x > 0 && mg.get(x - 1, y) != ManhattanGraph.WALL)
                    {
                        int v2 = nodeMap.get(new Node(x - 1, y));
                        gb.addEdge(v1, v2, 1.0f);
                    }
                    //Right
                    if (x < mg.width()-1 && mg.get(x + 1, y) != ManhattanGraph.WALL)
                    {
                        int v2 = nodeMap.get(new Node(x + 1, y));
                        gb.addEdge(v1, v2, 1.0f);
                    }
                    //Up
                    if (y > 0 && mg.get(x, y - 1) != ManhattanGraph.WALL)
                    {
                        int v2 = nodeMap.get(new Node(x, y - 1));
                        gb.addEdge(v1, v2, 1.0f);
                    }
                    //Down
                    if (y < mg.height() - 1 && mg.get(x, y + 1) != ManhattanGraph.WALL)
                    {
                        int v2 = nodeMap.get(new Node(x, y + 1));
                        gb.addEdge(v1, v2, 1.0f);
                    }
                }
            }
        }
        this.graph = gb.build();
    }


    @Override
    public DirectedGraph getGraph()
    {
        return graph;
    }

    @Override
    public int getStartNode()
    {
        return startNode;
    }

    @Override
    public int getTargetNode()
    {
        return targetNode;
    }

    @Override
    public Heuristic getHeuristic()
    {
        return this;
    }

    @Override
    public float h(int a, int b)
    {
        Node nodeA = nodes[a];
        Node nodeB = nodes[b];
        return Math.abs(nodeA.x - nodeA.x) + Math.abs(nodeA.y - nodeB.y);
    }

    public String asString(int node)
    {
        Node n = nodes[node];
        return "("+n.x+", "+n.y+")";
    }

    private static class Node
    {
        public final int x;
        public final int y;

        private Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            return y == node.y;
        }

        @Override
        public int hashCode()
        {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
