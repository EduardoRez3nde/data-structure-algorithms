#ifndef ADJACENCY_LIST_H
#define ADJACENCY_LIST_H

#include "DynamicArray.h"

typedef struct Node {
    int element;
    struct Node* next;
} Node;

typedef struct AdjacencyList {
    Node** list;
    int numberVertices;
    int numberEdges;
    int directed;
} AdjacencyList;

AdjacencyList* init_adjacency_list(int numberVertices, int isDirected);

void insert(AdjacencyList* list, int source, int destination);

Node* init_node(int destination, Node* next);

#endif