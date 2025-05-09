#include <stdio.h>

#include "adjacency_list/AdjacencyList.h"

int main() {

    Graph* graph = init_graph(10, 0);

    add(graph, 1, 3);
    print_graph(graph);

    return 0;
}

