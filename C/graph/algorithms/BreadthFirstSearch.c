
#include "BreadthFirstSearch.h"
#include "adjacency_list/AdjacencyList.h"

// O(v + E)
int* breadthFirstSearch(Graph* graph, int source) {

    int* discovered = malloc(sizeof(int) * graph->vertices);
    int* processed = malloc(sizeof(int) * graph->vertices);
    int* parent = malloc(sizeof(int) * graph->vertices);

    for (int i = 0; i < graph->vertices; i++) {
        discovered[i] = -1;
        processed[i] = -1;
        parent[i] = -1;
    }
    
    Queue* queue = create_queue();
    enqueue(queue, source);

    discovered[source] = 1;

    while (!isEmpty(queue)) {

        int v = dequeue(queue);
        processed[v] = 1;
        Node* current = graph->adj[v];

        while (current != NULL) {

            int edgeValue = current->vertex;

            if (discovered[edgeValue] == -1) {
                enqueue(queue, current->vertex);
                discovered[edgeValue] = 1;
                parent[edgeValue] = v;
            }
            current = current->next;
        }
    }
    free(discovered);
    // free(queue); lista ligada
    free(processed);
    return parent;
}
