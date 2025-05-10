#include <stdio.h>
#include "AdjacencyList.h"

// O(1)
Node* init_node(int adj) {

    Node* newest = malloc(sizeof(Node));
    newest->vertex = adj;
    newest->weight = 0;
    newest->next = NULL;

    return newest;
}

// O(n)
Graph* init_graph(int numberVertices, int isDirected) {

    Graph* graph = malloc(sizeof(Graph));
    graph->vertices = numberVertices;
    graph->edges = 0;
    graph->isDirected = isDirected;

    graph->adj = malloc(sizeof(Node*) * numberVertices);

    for (int i = 0; i < graph->vertices; i++) {
        graph->adj[i] = NULL;
    }
    return graph;
}

// Theta(1)
void add(Graph* graph, int vertice, int adj) {

    Node* node = init_node(adj);
    node->weight = 0;
    node->next = graph->adj[vertice];

    graph->adj[vertice] = node;

    if (!graph->isDirected) {
       Node* reverse = init_node(vertice);
       reverse->next = graph->adj[adj];
       graph->adj[adj] = reverse;
    }
    graph->edges++;
}

// O(n)
void print_graph(Graph* graph) {

    for (int i = 0; i < graph->vertices; i++) {

        Node* current = graph->adj[i];

        printf("%d -> ", i);

        while (current != NULL) {
            printf("%d -> ", current->vertex);
            current = current->next;
        }
        printf("NULL\n");
    }
}

