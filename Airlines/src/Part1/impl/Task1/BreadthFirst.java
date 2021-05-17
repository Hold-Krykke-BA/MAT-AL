package Part1.impl.Task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//procedure BFS(G, root) is
//    let Q be a queue
//    label root as discovered
//    Q.enqueue(root)
//    while Q is not empty do
//        v := Q.dequeue()
//        if v is the goal then
//            return v
//      for all edges from v to w in G.adjacentEdges(v) do
//          if w is not labeled as discovered then
//              label w as discovered
//               Q.enqueue(w)
public class BreadthFirst {
    Queue<String> queue;
    List<String> visited;
    IGraph1 graph;

    public BreadthFirst(IGraph1 graph1){
        this.queue = new LinkedList<>();
        this.visited = new ArrayList<>();
        this.graph = graph1;
    }

    public boolean hasPath(String src, String dest, String airline){
        visited.add(src);
        queue.add(src);
        while (!queue.isEmpty()){
            String current = queue.poll();
            System.out.println("Current: " + current);
            if (current.equals(dest)) {
                return true;
            }
            for(IEdge1 edge : graph.adj(current)){
                if(!edge.airline().equals(airline)){
                    System.out.println("NOT CONNECTED: " + " source: " + src + " current "+ current + " edge from " +edge.from() + " edge to " + edge.to() + " airline is: " + edge.airline());
                    continue;
                }
                if(!visited.contains(edge.to())){
                    System.out.println("*********************************************************************************************");
                    System.out.println("Connected: " + " source: " + src + " current "+ current + " edge from " +edge.from() + " edge to " + edge.to() + " airline is: " + edge.airline());
                    System.out.println("*********************************************************************************************");
                    visited.add(edge.to());
                    queue.add(edge.to());
                }
            }
        }
        return false;
    }
}
