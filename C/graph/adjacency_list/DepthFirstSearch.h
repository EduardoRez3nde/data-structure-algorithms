#include "AdjacencyList.h"

void depthFirstSearchRecursive(AdjacencyList* adjacencyList, int source, int* time, DynamicArray* discovered, int** timesPair);

int** depthFirstSearch(AdjacencyList* adjacencyList, int source);