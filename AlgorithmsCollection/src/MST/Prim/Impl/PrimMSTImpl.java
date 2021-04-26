package MST.Prim.Impl;

import Datastructures.Queues.Simple.Impl.QueueImpl;
import Graphs.Undirected.Interfaces.Edge;
import Graphs.Undirected.Interfaces.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

// MST is the least heavy tree connecting all vertices in a non-cyclic graph
public class PrimMSTImpl {

    private double totalMSTweight; // not used (yet?) might be useful?
    private QueueImpl<Edge> mst;
    private boolean[] markedVertices;
    private PriorityQueue<Edge> pq;

    public PrimMSTImpl(Graph graph){
        pq = new PriorityQueue<Edge>();
        markedVertices = new boolean[graph.V()];
        mst = new QueueImpl<Edge>();

        visit(graph, 0);

        while (!pq.isEmpty()) {
            Edge lowestWeightEdge = pq.remove();
            int v = lowestWeightEdge.either(), w = lowestWeightEdge.other(v);
            if (markedVertices[v] && markedVertices[w]) continue; // Skip if both are included
            mst.push(lowestWeightEdge); // Add edge to minimum spanning tree.
            // recursively visit the neighbouring vertices
            if (!markedVertices[v]) visit(graph, v);
            if (!markedVertices[w]) visit(graph, w);
        }
    }

    private void visit(Graph graph, int v) {
        markedVertices[v] = true;
        for (Edge e : graph.adj(v)){
            if (!markedVertices[e.other(v)]) pq.add(e);
        }
    }

    public Iterable<Edge> edges() {
        ArrayList<Edge> mstEdges = new ArrayList<Edge>();
        while (!mst.isEmpty()){
            try {
                mstEdges.add(mst.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mstEdges;
    }
}
