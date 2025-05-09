#include <stdlib.h>

typedef struct Node {
    int adfInfo;
    int weight;
    struct Node* next;
} Node;

typedef struct Graph {
    Node** adj;
    int vertices;
    int edges;
    int isDirected;
} Graph;

Node* init_node(int info);

Graph* init_graph(int numberVertices, int isDirected);

void add(Graph* graph, int vertice, int adj);

void print_graph(Graph* graph);

