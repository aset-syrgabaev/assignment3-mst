package edu.astanait.mst;

import java.util.*;

public class KruskalMST {

    static class DSU {
        private final Map<String, String> parent = new HashMap<>();

        public void makeSet(String v) {
            parent.put(v, v);
        }

        public String find(String v) {
            if (parent.get(v).equals(v)) return v;
            parent.put(v, find(parent.get(v)));
            return parent.get(v);
        }

        public void union(String a, String b) {
            a = find(a);
            b = find(b);
            if (!a.equals(b)) parent.put(a, b);
        }
    }

    public static class Result {
        List<Edge> mstEdges = new ArrayList<>();
        double totalCost = 0;
        long operations = 0;
        double execTimeMs = 0;
    }

    public static Result findMST(Graph graph) {
        long startTime = System.nanoTime();

        Result result = new Result();
        DSU dsu = new DSU();

        for (String vertex : graph.getVertices()) {
            dsu.makeSet(vertex);
        }

        List<Edge> edges = graph.getEdges();
        Collections.sort(edges);

        for (Edge e : edges) {
            result.operations++;
            String root1 = dsu.find(e.from);
            String root2 = dsu.find(e.to);

            if (!root1.equals(root2)) {
                result.mstEdges.add(e);
                result.totalCost += e.weight;
                dsu.union(root1, root2);
            }
        }

        long endTime = System.nanoTime();
        result.execTimeMs = (endTime - startTime) / 1_000_000.0;

        return result;
    }
}
