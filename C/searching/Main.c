#include <stdio.h>

#include "Search.h"
#include "../sorting/Sort.h"

int main() {

    int array[] = {38, 27, 43, 3, 9, 82, 10};
    int n = sizeof(array) / sizeof(array[0]);

    merge_sort(array, 0, n - 1);

    int key = binarySearchIterative(array, n, 82);
    
    for (int i = 0; i < n; i++) 
        printf("%d ", array[i]);
    
    printf("\n\nPosition: %d\n", key);

    return 0;
}

// Compilar: gcc searching/BinarySearch.c searching/Main.c sorting/MergeSort.c -o binSearch