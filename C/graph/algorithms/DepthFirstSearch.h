#include <stdbool.h>
#include "adjacency_list/AdjacencyList.h"

typedef struct DfsResult {
    bool* discovered;
    int* entry_time;
    int* parent;
    int* exit_time;
} DfsResult;

DfsResult* depthFirstSearch(Graph* graph, int source);
