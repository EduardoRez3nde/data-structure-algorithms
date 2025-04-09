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

