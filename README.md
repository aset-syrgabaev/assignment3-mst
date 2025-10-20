# assignment3-mst
Minimum Spanning Tree (Prim's and Kruskal's algorithms) assignment

# Assignment 3: Optimization of a City Transportation Network (MST)

## 🎯 Objective
The goal of this project is to apply **Prim’s** and **Kruskal’s** algorithms to find the **Minimum Spanning Tree (MST)** of a weighted undirected graph representing a city transportation network.

Each vertex corresponds to a district, and each edge represents a possible road with an associated construction cost.

---

## 🧩 Implementation Details
- Programming language: **Java 17**
- Build tool: **Maven**
- Library used: **Gson** (for reading/writing JSON)
- IDE: **IntelliJ IDEA**

---

## ⚙️ Algorithms Implemented
### **Prim’s Algorithm**
- Uses a priority queue.
- Starts from an arbitrary vertex and grows the MST one edge at a time.
- Suitable for **dense graphs**.

### **Kruskal’s Algorithm**
- Sorts all edges and adds them if they don’t form a cycle (using DSU/Union-Find).
- Suitable for **sparse graphs**.

---

## 📂 Input / Output
Input data is stored in `src/main/resources/input.json`,  
and results are written to `src/main/resources/output.json`.

Example result:
```json
{
  "graph_id": 1,
  "prim": {
    "total_cost": 16.0,
    "execution_time_ms": 1.81
  },
  "kruskal": {
    "total_cost": 16.0,
    "execution_time_ms": 23.15
  }
}
📊 Experimental Results
Graph ID	Vertices	Edges	Prim Cost	Kruskal Cost	Prim Time (ms)	Kruskal Time (ms)	Prim Ops	Kruskal Ops
1	5	7	16	16	1.81	23.15	7	7
2	4	5	6	6	0.06	0.23	5	5

🧠 Analysis
Both algorithms produced identical MST costs (as expected).

Prim’s algorithm was faster for these datasets.

Kruskal’s algorithm is easier to implement and works well on sparse graphs.

For dense graphs, Prim’s algorithm is generally more efficient due to the priority queue.

🏁 Conclusion
Both algorithms successfully generate the MST with minimal total cost.

Prim is preferable for dense graphs.

Kruskal is preferable for sparse graphs or when the graph is already edge-sorted.

📚 References
Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). Introduction to Algorithms.

Sedgewick, R., & Wayne, K. (2011). Algorithms, 4th Edition.

Grokking Algorithms — Aditya Bhargava (2016)