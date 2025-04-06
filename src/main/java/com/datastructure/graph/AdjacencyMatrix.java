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
                this.adjacencyMatrix[i][j] = false;
            }
        }
    }

    private boolean adjacencyOfEdgesDoesExist(final int from, final int to) {
        return this.adjacencyMatrix[from][to] != false;
    }

    private boolean vertexDoesExist(final int vertex) {
        return (vertex >= 0 && vertex < this.getVertexCount());
    }

    private boolean edgeDoesExist(final int from, final int to) {
        if (vertexDoesExist(from) && vertexDoesExist(to))
            return adjacencyOfEdgesDoesExist(from, to);
        return false;
    }

    public boolean addEdge(final int from, final int to) {
        if (vertexDoesExist(from) && vertexDoesExist(to)) {
            if (!edgeDoesExist(from, to)) {
                this.adjacencyMatrix[from][to] = true;
                if (!directed)
                    this.adjacencyMatrix[to][from] = true;
                edgesCount++;
                return true;
            }
        }
        return false;
     }

     public boolean removeEdge(final int from, final int to) {
        if (vertexDoesExist(from) && vertexDoesExist(to)) {
            if (edgeDoesExist(from, to)) {
                this.adjacencyMatrix[from][to] = false;
                if (!directed)
                    this.adjacencyMatrix[to][from] = false;
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

        System.out.print("\t\t");

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
