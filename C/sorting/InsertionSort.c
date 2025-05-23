
#include "Sort.h"

// Melhor Caso: Ω(n)
// Pior Caso: O(n²)
void insertion_sort(int array[], int size) {

    for (int i = 1; i < size; i++) {
        int key = array[i];
        int j = i - 1;
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j = j - 1;
        }
        array[j] = key;
    }
}