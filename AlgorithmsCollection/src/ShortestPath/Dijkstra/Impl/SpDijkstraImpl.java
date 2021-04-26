package ShortestPath.Dijkstra.Impl;

import Graphs.Directed.Interfaces.DirectedEdge;
import Graphs.Directed.Interfaces.DirectedGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SpDijkstraImpl {

    float[] weightArr;
    int[] pathArr;
    boolean[] visitedArr;
    PriorityQueue pq = new PriorityQueue(new WeightComparator());

    public SpDijkstraImpl(DirectedGraph directedGraph, int source) {
        weightArr = new float[directedGraph.V()];
        pathArr = new int[directedGraph.V()];
        visitedArr = new boolean[directedGraph.V()];
        for (int i = 0; i < directedGraph.V(); i++) {
            weightArr[i] = Float.MAX_VALUE;
            pathArr[i] = -1;
            visitedArr[i] = false;
        }
        weightArr[source] = 0;
        pq.add(source);

        while (!pq.isEmpty()) {
            int nextPq = (int) pq.poll();
            for(DirectedEdge e : directedGraph.adj(nextPq)) {
                if (!visitedArr[e.to()]) {
                    pq.add(e.to());
                    visitedArr[e.to()] = true;
                }
                float tempWeight = weightArr[nextPq] + e.weight();
                if (tempWeight < weightArr[e.to()]) {
                    weightArr[e.to()] = tempWeight;
                    pathArr[e.to()] = e.from();
                }
            }
        }
    }

    public String path(int to, ArrayList<Integer> pathArr) {
        if (this.pathArr[to] == -1) {
            StringBuilder builder = new StringBuilder();
            builder.append("Shortest path to " + pathArr.get(0) + "\n");
            for(int i = pathArr.size()-1; i >= 0; i--) {
                if (i == 0) {
                    builder.append(pathArr.get(i));
                } else {
                    builder.append(pathArr.get(i) + " -> ");
                }
            }
            return builder.toString();
        }
        if (pathArr == null) {
            pathArr = new ArrayList<>();
        }
        if (pathArr.isEmpty()) {
            pathArr.add(to);
        }
        pathArr.add(this.pathArr[to]);
        return path(this.pathArr[to], pathArr);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("   Weight | Path \n");
        for (int i = 0; i < weightArr.length; i++) {
            builder.append(i + ": ");
            builder.append(weightArr[i]);
            builder.append("    | ");
            builder.append(pathArr[i]);
            builder.append("\n");
        }
        return builder.toString();
    }

    class WeightComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            float f = weightArr[o1] - weightArr[o2];
            if (f > 0) return 1;
            if (f < 0) return -1;
            return 0;
        }
    }

}
