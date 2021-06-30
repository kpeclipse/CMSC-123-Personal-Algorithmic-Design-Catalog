package AlgorithmDesignTechniques.DynamicProgramming.FloydWarshallAlgorithm;

import DataStructure.Graph;

public class FloydWarshallAlgorithm {
    private static Graph graph;
    double[][] dist;
    int V;
    double MAX = Double.POSITIVE_INFINITY;

    public static void main(String[] args) {
        graph = new Graph(true);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addEdge("1", "2", 2);
        graph.addEdge("1", "4", 1);
        graph.addEdge("1", "5", 8);
        graph.addEdge("2", "1", 6);
        graph.addEdge("2", "3", 3);
        graph.addEdge("2", "4", 2);
        graph.addEdge("3", "4", 4);
        graph.addEdge("4", "3", 2);
        graph.addEdge("4", "5", 3);
        graph.addEdge("5", "1", 3);

        System.out.println("FLOYD-WARSHALL ALGORITHM:\n");
        new FloydWarshallAlgorithm(graph);
    }

    public FloydWarshallAlgorithm(Graph G) {
        V = G.getVertices().size();
        dist = new double[V][V];

        // If graph is unweighted
        if (G.getWeights() == null)
            System.out.print("GRAPH IS UNWEIGHTED!");

        else {
            initialize(G.getWeights());

            showMatrix(0);

            // Algorithm
            for (int k = 0; k < V; k++) {
                // Source Vertex
                for (int i = 0; i < V; i++)
                    // Destination Vertex
                    for (int j = 0; j < V; j++)
                        if (dist[i][j] > dist[i][k] + dist[k][j])
                            dist[i][j] = dist[i][k] + dist[k][j];

                showMatrix(k + 1);
            }
        }
    }

    public void initialize(double[][] wGraph) {
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                if (wGraph[i][j] > 0)
                    dist[i][j] = wGraph[i][j];
                else if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = MAX;
            }
    }

    public void showMatrix(int iteration) {
        System.out.println("D(" + iteration + ")");

        for (int i = 0; i < V; i++) {
            System.out.print("\t");
            for (int j = 0; j < V; j++) {
                if (dist[i][j] != MAX)
                    System.out.print("[" + dist[i][j] + "]  ");
                else
                    System.out.print("[INF]  ");
            }
            System.out.println();
        }
    }
}