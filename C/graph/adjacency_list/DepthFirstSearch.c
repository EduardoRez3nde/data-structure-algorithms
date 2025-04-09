#include "AdjacencyList.h"

void depthFirstSearchRecursive(AdjacencyList* adjacencyList, int source, int* time, DynamicArray* discovered, int** timesPair) {

    timesPair[source] = malloc(2 * sizeof(int));
    timesPair[source][0] = (*time)++;

    add(discovered, source);

    Node* current = adjacencyList->list[source];

    while (current != NULL) {
        int vertice = current->element;
        if (!contains(discovered, vertice)) {
            depthFirstSearchRecursive(adjacencyList, vertice, time, discovered, timesPair);
        }
        current = current->next;
    }
    timesPair[source][1] = (*time)++;
}

int** depthFirstSearch(AdjacencyList* adjacencyList, int source) {

    int time = 1;
    DynamicArray* discovered = createArray(adjacencyList->numberVertices);
    int** timesPair = malloc(adjacencyList->numberVertices * sizeof(int*));

    depthFirstSearchRecursive(adjacencyList, source, &time, discovered, timesPair);

    free(discovered);
    return timesPair;
}