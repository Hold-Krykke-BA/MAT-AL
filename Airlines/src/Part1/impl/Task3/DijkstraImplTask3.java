package Part1.impl.Task3;

import Part1.impl.DijkstraImpl;
import Part1.impl.DirectedGraph;
import Part1.interfaces.Edge;

import java.util.*;

public class DijkstraImplTask3 {
    HashMap<String, Float> weightMap;
    HashMap<String, String> pathMap;
    HashMap<String, Boolean> visitedMap;
    PriorityQueue pq = new PriorityQueue(new WeightComparator());
    ArrayList<String> shortestPathArr = new ArrayList<>();

    public DijkstraImplTask3(GraphTask3 directedGraph, String source) {
        weightMap = new HashMap<>();
        pathMap = new HashMap<>();
        visitedMap = new HashMap<>();
        weightMap.put(source, (float) 0);
        visitedMap.put(source, false);
        pq.add(source);

        while (!pq.isEmpty()) {
            String nextPq = (String) pq.poll();
            for(EdgeTask3 e : directedGraph.adj(nextPq)) {
                visitedMap.putIfAbsent(e.to(), false);
                if (!visitedMap.get(e.to())) {
                    pq.add(e.to());
                    visitedMap.put(e.to(), true);
                }
                float tempWeight = weightMap.get(nextPq) + e.weight();
                weightMap.putIfAbsent(e.to(), Float.MAX_VALUE);
                if (tempWeight < weightMap.get(e.to())) {
                    //Add + 1 for one hour transfer
                    weightMap.put(e.to(), tempWeight + 1);
                    pathMap.put(e.to(), e.from());
                }
            }
        }
    }

    public String path(String to) {
        if (shortestPathArr.size() != 0 && pathMap.get(to) == null) {
            StringBuilder builder = new StringBuilder();
            builder.append("Shortest path to " + shortestPathArr.get(0) + "\n");
            for(int i = shortestPathArr.size()-1; i >= 0; i--) {
                if (i == 0) {
                    builder.append(shortestPathArr.get(i));
                } else {
                    builder.append(shortestPathArr.get(i) + " -> ");
                }
            }
            return builder.toString();
        }
        if (shortestPathArr == null) {
            shortestPathArr = new ArrayList<>();
        }
        if (shortestPathArr.isEmpty()) {
            shortestPathArr.add(to);
        }
        shortestPathArr.add(pathMap.get(to));
        return path(pathMap.get(to));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("     Weight     | Path \n");
        for (String key : weightMap.keySet()) {
            builder.append(key + ": ");
            builder.append(weightMap.get(key));
            builder.append("  | ");
            builder.append(pathMap.get(key));
            builder.append("\n");
        }
        return builder.toString();
    }

    class WeightComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            weightMap.putIfAbsent(o1, Float.MAX_VALUE);
            weightMap.putIfAbsent(o2, Float.MAX_VALUE);
            float f = weightMap.get(o1) - weightMap.get(o2);
            if (f > 0) return 1;
            if (f < 0) return -1;
            return 0;
        }
    }
}
