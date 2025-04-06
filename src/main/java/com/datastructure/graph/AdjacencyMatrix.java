package com.datastructure.graph;

public class AdjacencyMatrix {

    private final boolean[][] adjacencyMatrix;
    private final int vertexCount;
    private int edgesCount;
    private final boolean directed;

    public AdjacencyMatrix(final int givenNumberOfVertices, final boolean isDirected) {

        this.vertexCount = givenNumberOfVertices;
        this.edgesCount = 0;
        this.directed = isDirected;
        this.adjacencyMatrix = new boolean[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                this.adjacencyMatrix[i][j] = Edges.EDGES_NONE.value;
            }
        }
    }

    public boolean adjacencyOfEdgesDoesExist(final int from, final int to) {
        return this.adjacencyMatrix[from][to] != Edges.EDGES_NONE.value;
    }

    public boolean vertexDoesExist(final int vertex) {
        return (vertex >= 0 && vertex < this.getVertexCount());
    }

    public boolean edgeDoesExist(final int from, final int to) {
        if (vertexDoesExist(from) && vertexDoesExist(to))
            return adjacencyOfEdgesDoesExist(from, to);
        return false;
    }

    public boolean addEdge(final int from, final int to) {
        if (vertexDoesExist(from) && vertexDoesExist(to)) {
            if (!edgeDoesExist(from, to)) {
                this.adjacencyMatrix[from][to] = Edges.EDGES_EXIST.value;
                if (!directed)
                    this.adjacencyMatrix[to][from] = Edges.EDGES_EXIST.value;
                edgesCount++;
                return true;
            }
        }
        return false;
     }

     public boolean removeEdge(final int from, final int to) {
        if (vertexDoesExist(from) && vertexDoesExist(to)) {
            if (edgeDoesExist(from, to)) {
                this.adjacencyMatrix[from][to] = Edges.EDGES_NONE.value;
                if (!directed)
                    this.adjacencyMatrix[to][from] = Edges.EDGES_NONE.value;
                edgesCount++;
                return true;
            }
        }
        return false;
     }

    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgesCount() {
        return edgesCount;
    }

    public void printGraph() {

        final String GREEN = "\u001B[32m";
        final String RESET = "\u001B[0m";

        System.out.print("\t\t"); // espaço antes do cabeçalho

        // Imprime o cabeçalho (índices das colunas)
        for (int i = 0; i < vertexCount; i++) {
            System.out.printf("%d\t\t", i);
        }
        System.out.println();
        for (int i = 0; i < vertexCount; i++) {
            System.out.printf("%d\t ", i);
            for (int j = 0; j < vertexCount; j++) {
                System.out.printf("%s\t ", adjacencyMatrix[i][j] ? GREEN + "true" + RESET : "false");
            }
            System.out.println();
        }
    }
}
