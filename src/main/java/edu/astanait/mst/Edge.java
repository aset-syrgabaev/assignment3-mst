package edu.astanait.mst;

public class Edge implements Comparable<Edge> {
    String from;
    String to;
    double weight;

    public Edge(String from, String to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return from + " - " + to + " (" + weight + ")";
    }
}
