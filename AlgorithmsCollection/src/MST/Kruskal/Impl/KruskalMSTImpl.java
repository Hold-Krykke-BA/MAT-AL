package MST.Kruskal.Impl;

import Datastructures.Queues.Priority.Impl.MinPriorityQueueImpl;
import Datastructures.Queues.Priority.Interfaces.MinPriorityQueue;
import Datastructures.UnionFind.Impl.WeightedUF;
import Datastructures.UnionFind.Interfaces.UnionFind;
import Graphs.Undirected.Interfaces.Edge;
import Graphs.Undirected.Interfaces.Graph;
import java.util.ArrayList;
import java.util.List;

public class KruskalMSTImpl {
    private final Graph graph;
    private final UnionFind unionFind;

    public KruskalMSTImpl(Graph graph) {
        this.graph = graph;
        this.unionFind = new WeightedUF(graph.E());
    }

    public List<Edge> getMSTedges() {
        List<Edge> list = new ArrayList<>();
        MinPriorityQueue<Edge> queue = new MinPriorityQueueImpl<>();
        graph.edges().forEach(edge -> queue.insert(edge));
        while (!queue.isEmpty()){
            // remove smallest Edge and check if both vertices of this edge is connected
            Edge minEdge = queue.delMin();
            if(!unionFind.isConnected(minEdge.either(), minEdge.other(minEdge.either()))){
                list.add(minEdge);
                unionFind.union(minEdge.either(), minEdge.other(minEdge.either()));
            }
        }
        return list;
    }
}

