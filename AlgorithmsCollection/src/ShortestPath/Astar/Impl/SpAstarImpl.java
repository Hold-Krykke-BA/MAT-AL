//package ShortestPath.Astar.Impl;
//
//import Graphs.Directed.Impl.DirectedGraphFactoryImpl;
//import Graphs.Directed.Interfaces.DirectedEdge;
//import Graphs.Directed.Interfaces.DirectedGraph;
//import Graphs.Directed.Interfaces.DirectedGraphBuilder;
//import ShortestPath.Astar.Interfaces.Heuristic;
//import ShortestPath.Astar.Interfaces.ManhattanGraph;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class SpAstarImpl implements Heuristic {
//
//    float[] weightArr;
//    int[] pathArr;
//    boolean[] visitedArr;
//    PriorityQueue pq = new PriorityQueue(new WeightComparator());
//    ArrayList<Integer> shortestPathArr = new ArrayList<>();
//
//    ManhattanGraph mg = new ExampleManhattanGraph();
//
//    public SpAstarImpl(DirectedGraph directedGraph, int source) {
//        weightArr = new float[directedGraph.V()];
//        pathArr = new int[directedGraph.V()];
//        visitedArr = new boolean[directedGraph.V()];
//        for (int i = 0; i < directedGraph.V(); i++) {
//            weightArr[i] = Float.MAX_VALUE;
//            pathArr[i] = -1;
//            visitedArr[i] = false;
//        }
//        weightArr[source] = 0;
//        pq.add(source);
//
//        while (!pq.isEmpty()) {
//            int nextPq = (int) pq.poll();
//            for(DirectedEdge e : directedGraph.adj(nextPq)) {
//                if (!visitedArr[e.to()]) {
//                    pq.add(e.to());
//                    visitedArr[e.to()] = true;
//                }
//                float tempWeight = weightArr[nextPq] + e.weight();
//                if (tempWeight < weightArr[e.to()]) {
//                    weightArr[e.to()] = tempWeight;
//                    pathArr[e.to()] = e.from();
//                }
//            }
//        }
//    }
//
//    public String path(int to) {
//        if (pathArr[to] == -1) {
//            StringBuilder builder = new StringBuilder();
//            builder.append("Shortest path to " + shortestPathArr.get(0) + "\n");
//            for(int i = shortestPathArr.size()-1; i >= 0; i--) {
//                if (i == 0) {
//                    builder.append(shortestPathArr.get(i));
//                } else {
//                    builder.append(shortestPathArr.get(i) + " -> ");
//                }
//            }
//            return builder.toString();
//        }
//        if (shortestPathArr == null) {
//            shortestPathArr = new ArrayList<>();
//        }
//        if (shortestPathArr.isEmpty()) {
//            shortestPathArr.add(to);
//        }
//        shortestPathArr.add(pathArr[to]);
//        return path(pathArr[to]);
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("   Weight | Path \n");
//        for (int i = 0; i < weightArr.length; i++) {
//            builder.append(i + ": ");
//            builder.append(weightArr[i]);
//            builder.append("    | ");
//            builder.append(pathArr[i]);
//            builder.append("\n");
//        }
//        return builder.toString();
//    }
//
//    @Override
//    public float h(int a, int b) {
//        return 0;
//    }
//
//
//    class WeightComparator implements Comparator<Integer> {
//
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            float f = weightArr[o1] - weightArr[o2];
//            if (f > 0) return 1;
//            if (f < 0) return -1;
//            return 0;
//        }
//    }
//
//}
