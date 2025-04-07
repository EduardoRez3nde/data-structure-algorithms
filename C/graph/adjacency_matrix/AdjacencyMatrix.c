#include <stdlib.h>
#include "AdjacencyMatrix.h";

AdjacencyMatrix *init_adjacency_matrix(int numberVertices, int isDirected) {

    AdjacencyMatrix *graph = malloc(sizeof(AdjacencyMatrix*));
    graph->directed = isDirected;
    graph->numberEdges = 0;
    graph->numberVertices = numberVertices;
    graph->matrix = malloc(numberVertices * sizeof(int));

    for (int i = 0; i < numberVertices; i++) {   // O(n)
        graph->matrix[i] = malloc(numberVertices * sizeof(int));
    }

    for (int i = 0; i < numberVertices; i++) {   // O(n²)
        for (int j = 0; j < numberVertices; j++) {
            graph->matrix[i][j] = 0;
        }
    }
}

void insert(AdjacencyMatrix *adjacencyMatrix, int source, int destination) {
    if (adjacencyMatrix->matrix[source][destination] == 0) {    // O(1)
        adjacencyMatrix->matrix[source][destination] = 1;
        if (!adjacencyMatrix->directed) {
            adjacencyMatrix->matrix[destination][source] = 1;
        }
        adjacencyMatrix->numberEdges++;
    }
}

void remover(AdjacencyMatrix *adjacencyMatrix, int source, int destination) {
    if (adjacencyMatrix->matrix == 1) {     // O(1)
        adjacencyMatrix->matrix[source][destination] = 0;
        if (!adjacencyMatrix->directed) {
            adjacencyMatrix->matrix[destination][source];
        }
        adjacencyMatrix->numberEdges--;
    }
}





