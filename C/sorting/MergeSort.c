#include <stdlib.h>

#include "Sort.h"

void merge_sort(int array[], int start, int end) {

    if (start < end) {
    
        int mid = (start + end) / 2;

        merge_sort(array, start, mid);
        merge_sort(array, mid + 1, end);
        merge(array, start, mid, end);
    }
}

void merge(int array[], int start, int mid, int end){

    int* temp = malloc((end + 1) * sizeof(int));
    int i = start;
    int j = mid + 1;
    int k = start;

    while (i <= mid && j <= end) {
        
        if (array[i] < array[j])
            temp[k++] = array[i++];
    
        else
            temp[k++] = array[j++];
    }

    while (i <= mid) {
        temp[k++] = array[i++];
    }

    while (j <= end) {
        temp[k++] = array[j++];
    }

    for (i = start; i <= end; i++) {
        array[i] = temp[i];
    }
}