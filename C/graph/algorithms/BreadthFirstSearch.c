
#include "BreadthFirstSearch.h"


void breadthFirstSearch(Graph* graph, int source) {

    int discovered[graph->vertices];
    int processed[graph->vertices];
    int parent[graph->vertices];

    for (int i = 0; i < graph->vertices; i++) {
        discovered[i] = -1;
        processed[i] = -1;
        parent[i] = -1;
    }
    
    Queue* queue = create_queue(queue);
    enqueue(queue, source);

    discovered[source] = 1;

    while (!isEmpty(queue)) {

        int value = dequeue(queue);
    }
}
