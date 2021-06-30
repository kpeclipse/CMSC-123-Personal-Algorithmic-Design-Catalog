package AlgorithmDesignTechniques.Greedy.PrimAlgorithm;

import java.util.ArrayList;

import DataStructure.Edge;
import DataStructure.Graph;
import DataStructure.Vertex;

public class PrimAlgorithm {
    private ArrayList<Edge> MSTedges = new ArrayList<Edge>();

    public static void main(String[] args) {
        Graph graph = new Graph(false);
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addEdge("0", "1", 2);
        graph.addEdge("0", "3", 6);
        graph.addEdge("1", "2", 3);
        graph.addEdge("1", "3", 8);
        graph.addEdge("1", "4", 5);
        graph.addEdge("2", "4", 7);
        graph.addEdge("3", "4", 9);

        new PrimAlgorithm(graph);
    }

    public PrimAlgorithm(Graph g) {
        ArrayList<Vertex> visitedList = new ArrayList<Vertex>();
        boolean[] visited = new boolean[g.getVertices().size()];

        for (int i = 0; i < g.getVertices().size() - 1; i++) {
            double minWeight = Double.POSITIVE_INFINITY;
            Edge chosenEdge = null;

            // Pick first node
            if (visitedList.size() == 0) {
                visitedList.add(g.getVertices().get(i));
                visited[i] = true;
            }

            for (Vertex v : visitedList) {
                int j = v.getAdjacentVertices().size();
                int k = 0;

                int first = g.getVertices().indexOf(v);

                while (k < j) {
                    Vertex adjVertex = v.getAdjacentVertices().get(k);
                    int second = g.getVertices().indexOf(adjVertex);

                    if (g.getWeights()[first][second] < minWeight && !visited[second]) {
                        minWeight = g.getWeights()[first][second];
                        chosenEdge = new Edge(v, g.getVertices().get(second), minWeight);
                    }

                    k += 1;
                }
            }

            visited[g.getVertices().indexOf(chosenEdge.getSecond())] = true;
            visitedList.add(chosenEdge.getSecond());
            MSTedges.add(chosenEdge);
        }

        System.out.println("PRIM'S ALGORITHM\n");
        showMinimumSpanningTree();
    }

    public void showMinimumSpanningTree() {
        for (Edge edge : MSTedges) {
            System.out.println("Edge: " + edge.getFirst().getKey() + " to " + edge.getSecond().getKey()
                    + "\t\t Weight: " + edge.getValue());
        }
    }
}