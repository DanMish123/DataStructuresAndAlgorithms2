import java.util.*;

public class Naloga3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String graphType = scanner.next();
        String action = scanner.next();

        Graph graph= readGraph(scanner, graphType);

        switch (action) {
            case "info":
                printGraphInfo(graph, graphType.equals("directed"));
                break;
            default:
                System.out.println("Invalid action.");
        }
    }

    private static Graph readGraph(Scanner scanner, String graphType) {
        int vertices = scanner.nextInt();
        boolean directed = graphType.equals("directed");
        Graph graph = new Graph(vertices, directed);

        while (scanner.hasNextInt()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.addEdge(from, to);
        }

        return graph;
    }

    private static void printGraphInfo(Graph graph, boolean directed) {
        System.out.println(graph.getVertices() + " " + graph.getEdges());

        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.println(i + " " + graph.getDegree(i, directed));
        }
    }
}

class Graph {
    private int vertices;
    private List<List<Integer>> adjList;
    private boolean directed;


    public Graph(int vertices, boolean directed) {
        this.vertices = vertices;
        this.directed = directed;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public int getVertices() {
        return vertices;
    }

    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
        if (!directed) {
            adjList.get(to).add(from);
        }
    }

    public int getDegree(int vertex, boolean directed) {
        return directed ? getOutDegree(vertex) + getInDegree(vertex) : getOutDegree(vertex);
    }

    private int getOutDegree(int vertex) {
        return adjList.get(vertex).size();
    }

    private int getInDegree(int vertex) {
        int inDegree = 0;
        for (int i = 0; i < vertices; i++) {
            if (i != vertex && adjList.get(i).contains(vertex)) {
                inDegree++;
            }
        }
        return inDegree;
    }

    public List<Integer> getNeighbors(int vertex) {
        return adjList.get(vertex);
    }


    public int getEdges() {
        int edges = 0;
        for (int i = 0; i < vertices; i++) {
            edges += getOutDegree(i);
            if (directed) {
                edges += getInDegree(i);
            }
        }
        return directed ? edges : edges / 2;
    }
}
