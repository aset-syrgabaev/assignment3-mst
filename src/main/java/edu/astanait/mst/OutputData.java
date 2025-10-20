package edu.astanait.mst;

import java.util.List;

public class OutputData {
    public List<Result> results;

    public static class Result {
        public int graph_id;
        public InputStats input_stats;
        public AlgorithmResult prim;
        public AlgorithmResult kruskal;
    }

    public static class InputStats {
        public int vertices;
        public int edges;
    }

    public static class AlgorithmResult {
        public List<EdgeInfo> mst_edges;
        public double total_cost;
        public long operations_count;
        public double execution_time_ms;
    }

    public static class EdgeInfo {
        public String from;
        public String to;
        public double weight;
    }
}
