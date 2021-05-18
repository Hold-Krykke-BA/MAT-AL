package Part1.impl.Task1;

import java.util.*;

//  procedure DFS_iterative(G, v) is
//      let S be a stack
//      S.push(v)
//      while S is not empty do
//          v = S.pop()
//          if v is not labeled as discovered then
//              label v as discovered
//              for all edges from v to w in G.adjacentEdges(v) do
//                  S.push(w)
public class DepthFirst {
    Stack<String> stack;
    List<String> visited;
    IGraph1 graph;

    public DepthFirst(IGraph1 graph1) {
        this.stack = new Stack<>();
        this.visited = new ArrayList<>();
        this.graph = graph1;
    }

    public boolean hasConnection(String src, String dest, String airline) {
        visited.add(src);
        stack.add(src);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (current.equals(dest)) {
                System.out.println("DFS - Visited:\n" + visited.toString() + "\nVisited amount: " + visited.size());
                return true;
            }
            for (IEdge1 edge : graph.adj(current)) {
                if (!edge.airline().equals(airline)) {
                    continue;
                }
                if (!visited.contains(edge.to())) {
                    visited.add(edge.to());
                    stack.add(edge.to());
                }
            }
        }
        System.out.println("DFS - Visited:\n" + visited.toString() + "\nVisited amount: " + visited.size());
        return false;
    }
}
