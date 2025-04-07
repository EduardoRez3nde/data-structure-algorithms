package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return this.adjacencyMatrix[from][to];
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

    public void depthFirstSearchRecursive(final int source) {
        Map<Integer, List<Integer>> outputAndInput = new HashMap<>();
        int time = 0;
        depthFirstSearchRecursiveImpl(source, outputAndInput, time);
    }

    private void depthFirstSearchRecursiveImpl(int source, Map<Integer, List<Integer>> outputAndInput, int time) {
        outputAndInput.put(source, new ArrayList<>());
        outputAndInput.get(source).add(++time);
        for (int i = 0; i < vertexCount; i++) {
            if (adjacencyMatrix[source][i] && outputAndInput.get(source).get(i) == null) {
                depthFirstSearchRecursiveImpl(i, outputAndInput, time);
            }
        }
        outputAndInput.get(source + 1).add(++time);
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
