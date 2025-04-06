package com.datastructure;

import com.datastructure.graph.AdjacencyList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AdjacencyList<Integer> graph = new AdjacencyList<>(false);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        List<Integer> vertices = graph.breadthFirstSearch(2);

        graph.printGraph();
        System.out.println();

        vertices.forEach(System.out::println);
    }
}