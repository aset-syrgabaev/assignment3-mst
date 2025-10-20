package edu.astanait.mst;

import java.util.*;

public class PrimMST {
    public static class Result {
        List<Edge> mstEdges = new ArrayList<>();
        double totalCost = 0;
        long operations = 0;
        double execTimeMs = 0;
    }

    public static Result findMST(Graph graph) {
        long startTime = System.nanoTime();

        Result result = new Result();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        String startVertex = graph.getVertices().iterator().next();
        visited.add(startVertex);
        pq.addAll(graph.adjList.get(startVertex));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            result.operations++;

            if (visited.contains(edge.to)) continue;

            visited.add(edge.to);
            result.mstEdges.add(edge);
            result.totalCost += edge.weight;

            for (Edge next : graph.adjList.get(edge.to)) {
                if (!visited.contains(next.to)) pq.offer(next);
            }
        }

        long endTime = System.nanoTime();
        result.execTimeMs = (endTime - startTime) / 1_000_000.0;
        return result;
    }
}
