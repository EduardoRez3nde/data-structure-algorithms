package com.datastructure.graph;

import java.util.*;

public class AdjacencyList<T extends Comparable<T>> {

    private final Map<T, Set<T>> adjacencyList;
    private boolean isDirected;

    public AdjacencyList(final boolean isDirected) {
        this.adjacencyList = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addEdge(final T source, final T destination) {
        adjacencyList.putIfAbsent(source, new HashSet<>());
        adjacencyList.putIfAbsent(destination, new HashSet<>());
        adjacencyList.get(source).add(destination);
        if (!isDirected)
            adjacencyList.get(destination).add(source);
    }

    public void removeEdge(final T source, final T destination) {
        if (this.adjacencyList.containsKey(source))
            this.adjacencyList.get(source).remove(destination);
        if (!isDirected && adjacencyList.containsKey(destination))
            this.adjacencyList.get(destination).remove(source);
    }

    public List<T> breadthFirstSearch(final T source) {

        final List<T> visitedOrder = new ArrayList<>();

        if (!adjacencyList.containsKey(source)) {
            System.out.println("Initial Vertice not found");
            return visitedOrder;
        }

        final Queue<T> queue = new LinkedList<>();
        final Set<T> discovered = new HashSet<>();

        queue.add(source);
        discovered.add(source);

        while (!queue.isEmpty()) {
            final T vertex = queue.poll();
            visitedOrder.add(vertex);

            for (T neighbor : adjacencyList.get(vertex)) {
                if (!discovered.contains(neighbor)) {
                    discovered.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visitedOrder;
    }

    public void printGraph() {
        for (Map.Entry<T, Set<T>> entry : adjacencyList.entrySet()) {
            System.out.printf("%s\t%s%n", entry.getKey(), entry.getValue());
        }
    }
}
