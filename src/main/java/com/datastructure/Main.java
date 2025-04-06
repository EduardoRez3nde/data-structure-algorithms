package com.datastructure;

import com.datastructure.graph.AdjacencyMatrix;

public class Main {
    public static void main(String[] args) {

        AdjacencyMatrix graph = new AdjacencyMatrix(10, false);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(5, 4);
        graph.addEdge(1, 6);
        graph.addEdge(5, 7);
        graph.addEdge(3, 2);
        graph.addEdge(2, 9);

        graph.printGraph();
    }
}