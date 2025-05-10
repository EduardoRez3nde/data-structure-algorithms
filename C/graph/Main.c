#include <stdio.h>

#include "algorithms/DepthFirstSearch.h"

int main() {

    Graph* graph = init_graph(6, 1);

    add(graph, 5, 5);
    add(graph, 4, 5);
    add(graph, 4, 2);
    add(graph, 3, 1);
    add(graph, 2, 3);
    add(graph, 1, 2);
    add(graph, 0, 3);
    add(graph, 0, 1);

    print_graph(graph);

    DfsResult* result = depthFirstSearch(graph, 0);

    printf("\n\n");

    for (int i = 0; i < graph->vertices; i++) {
        printf("%d-> (%d, %d)\n", i, result->entry_time[i], result->exit_time[i]);
    }
    printf("\n\n");

    for (int i = 0; i < graph->vertices; i++) {
        printf("%d ", result->parent[i]);
    }

    return 0;
}

