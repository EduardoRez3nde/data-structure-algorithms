#include <stdbool.h>
#include "DepthFirstSearch.h"

DfsResult* dfs(Graph* graph, int source, int* time, DfsResult* result) {

    (*time)++;
    result->discovered[source] = true;
    result->entry_time[source] = (*time);

    Node* current = graph->adj[source];

    while (current != NULL) {

        int v = current->vertex;
        if (result->discovered[v] == false) {
            result->parent[v] = source;
            dfs(graph, v, time, result);
        }
        current = current->next;
    }

    (*time)++;
    result->exit_time[source] = (*time);
    
    return result;
}

DfsResult* depthFirstSearch(Graph* graph, int source) {

    DfsResult* dfsResult = (DfsResult*) malloc(sizeof(DfsResult));

    dfsResult->discovered = (bool*) malloc(sizeof(bool) * graph->vertices);
    dfsResult->entry_time = (int*) malloc(sizeof(int) * graph->vertices);
    dfsResult->parent = (int*) malloc(sizeof(int) * graph->vertices);
    dfsResult->exit_time = (int*) malloc(sizeof(int) * graph->vertices);

    for (int i = 0; i < graph->vertices; i++) {
        dfsResult->discovered[i] = false;
        dfsResult->entry_time[i] = 0;
        dfsResult->parent[i] = -1;
        dfsResult->exit_time[i] = 0;
    }
    int time = 0;
    return dfs(graph, source, &time, dfsResult);
}