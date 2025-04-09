#include <stdio.h>

#include "AdjacencyList.h"
#include "DynamicArray.h"

int main() {

    AdjacencyList* graph = init_adjacency_list(5, 0); // 5 vértices, grafo não-direcionado
    insert(graph, 1, 2);
    insert(graph, 1, 3);
    insert(graph, 2, 4);
    insert(graph, 3, 4);


    DynamicArray* processed = breadthFirstSearch(graph, 1);
    printArray(processed);

    return 0;
}