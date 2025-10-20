package edu.astanait.mst;

import java.util.List;

public class InputData {
    public List<GraphData> graphs;

    public static class GraphData {
        public int id;
        public List<String> nodes;
        public List<EdgeData> edges;
    }

    public static class EdgeData {
        public String from;
        public String to;
        public double weight;
    }
}
