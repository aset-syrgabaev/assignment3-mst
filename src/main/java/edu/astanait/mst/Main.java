package edu.astanait.mst;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/main/resources/input.json";
        String outputPath = "src/main/resources/output.json";

        InputData inputData = JsonUtils.readInput(inputPath);
        if (inputData == null || inputData.graphs == null) {
            System.out.println("Ошибка: не удалось прочитать входные данные.");
            return;
        }

        OutputData outputData = new OutputData();
        outputData.results = new ArrayList<>();

        for (InputData.GraphData g : inputData.graphs) {
            Graph graph = new Graph();
            for (InputData.EdgeData e : g.edges) {
                graph.addEdge(e.from, e.to, e.weight);
            }

            PrimMST.Result prim = PrimMST.findMST(graph);
            KruskalMST.Result kruskal = KruskalMST.findMST(graph);

            OutputData.Result result = new OutputData.Result();
            result.graph_id = g.id;

            OutputData.InputStats stats = new OutputData.InputStats();
            stats.vertices = g.nodes.size();
            stats.edges = g.edges.size();
            result.input_stats = stats;

            result.prim = convertToAlgorithmResult(prim);
            result.kruskal = convertToAlgorithmResult(kruskal);

            outputData.results.add(result);
        }

        JsonUtils.writeOutput(outputPath, outputData);
        System.out.println("✅ Результаты сохранены в " + outputPath);
    }

    private static OutputData.AlgorithmResult convertToAlgorithmResult(PrimMST.Result res) {
        OutputData.AlgorithmResult alg = new OutputData.AlgorithmResult();
        alg.total_cost = res.totalCost;
        alg.operations_count = res.operations;
        alg.execution_time_ms = res.execTimeMs;

        alg.mst_edges = new ArrayList<>();
        for (Edge e : res.mstEdges) {
            OutputData.EdgeInfo ei = new OutputData.EdgeInfo();
            ei.from = e.from;
            ei.to = e.to;
            ei.weight = e.weight;
            alg.mst_edges.add(ei);
        }

        return alg;
    }

    private static OutputData.AlgorithmResult convertToAlgorithmResult(KruskalMST.Result res) {
        OutputData.AlgorithmResult alg = new OutputData.AlgorithmResult();
        alg.total_cost = res.totalCost;
        alg.operations_count = res.operations;
        alg.execution_time_ms = res.execTimeMs;

        alg.mst_edges = new ArrayList<>();
        for (Edge e : res.mstEdges) {
            OutputData.EdgeInfo ei = new OutputData.EdgeInfo();
            ei.from = e.from;
            ei.to = e.to;
            ei.weight = e.weight;
            alg.mst_edges.add(ei);
        }

        return alg;
    }
}
