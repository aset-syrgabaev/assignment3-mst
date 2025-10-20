package edu.astanait.mst;

import java.util.*;

public class Graph {
    public Map<String, List<Edge>> adjList = new HashMap<>();

    public void addEdge(String from, String to, double weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(new Edge(from, to, weight));
        adjList.get(to).add(new Edge(to, from, weight)); // для неориентированного графа
    }

    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for (var entry : adjList.entrySet()) {
            for (Edge e : entry.getValue()) {
                String key = e.from + "-" + e.to;
                String rev = e.to + "-" + e.from;
                if (!seen.contains(key) && !seen.contains(rev)) {
                    edges.add(e);
                    seen.add(key);
                    seen.add(rev);
                }
            }
        }
        return edges;
    }

    public Set<String> getVertices() {
        return adjList.keySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var entry : adjList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
