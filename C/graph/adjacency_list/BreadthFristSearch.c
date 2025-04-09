#ifndef BREADTH_FIRST_SEARCH_H
#define BREADTH_FIRST_SEARCH_H

#include "DynamicArray.h"
#include "AdjacencyList.h"
#include "Queue.h"

DynamicArray* breadthFirstSearch(AdjacencyList* adjacencyList, int source) {

    DynamicArray* processed = createArray(adjacencyList->numberVertices);
    
    if (source < 0 || source >= adjacencyList->numberVertices)
        return processed;

    Queue* queue = createQueue();
    DynamicArray* discovered = createArray(adjacencyList->numberVertices);

    enqueue(queue, source);
    add(discovered, source);

    while (!isEmpty(queue)) {
        int vertice = dequeue(queue);
        add(processed, vertice);
        
        for (Node* current = adjacencyList->list[vertice]; current != NULL; current = current->next) {
            if (!contains(discovered, current->element)) {
                enqueue(queue, current->element);
                add(discovered, current->element);
            }
        }
    }
    return processed;
}
#endif