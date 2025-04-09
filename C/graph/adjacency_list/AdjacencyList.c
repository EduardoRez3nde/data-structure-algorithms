#include <stdlib.h>

#include "AdjacencyList.h"
#include "Queue.h"
#include "DynamicArray.h"

AdjacencyList* init_adjacency_list(int numberVertices, int isDirected) {

    AdjacencyList* adjacencyList = malloc(sizeof(AdjacencyList*));
    adjacencyList->numberEdges = 0;
    adjacencyList->directed = isDirected;
    adjacencyList->numberVertices = numberVertices;
    adjacencyList->list = malloc(numberVertices * sizeof(Node*));

    for (int i = 0; i < numberVertices; i++) {
        adjacencyList->list[i] = NULL;
    }
    return adjacencyList;
}

void insert(AdjacencyList* list, int source, int destination) {

    Node* node = list->list[source];

    while (node != NULL) {
        if (node->element == destination)
            return;
        node = node->next;
    }
    list->list[source] = init_node(destination, list->list[source]);

    if (!list->directed) {
        node = list->list[destination];

        while (node != NULL) {
            if (node->element == source) 
                return;
            node = node->next;
        }
        list->list[destination] = init_node(source, list->list[destination]);
    }
    list->numberEdges++;
}

Node* init_node(int destination, Node* next) {
    Node* newest = malloc(sizeof(Node));
    newest->element = destination;
    newest->next = next;
    return newest;
}

DynamicArray* breadthFirstSearch(AdjacencyList* adjacencyList, int source) {

    DynamicArray* processed = createArray(adjacencyList->numberVertices);
    
    if (source < 0 || source >= adjacencyList->numberVertices)
        return processed;

    Queue* queue = createQueue();
    DynamicArray* discovered = createArray(adjacencyList->numberVertices);

    enqueue(queue, source);
    add(discovered, source);

    while (!isEmpty(queue)) {
        int vertice = dequeue(queue);
        add(processed, vertice);
        
        for (Node* current = adjacencyList->list[vertice]; current != NULL; current = current->next) {
            if (!contains(discovered, current->element)) {
                enqueue(queue, current->element);
                add(discovered, current->element);
            }
        }
    }
    return processed;
}

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
