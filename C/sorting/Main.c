#include <stdio.h>
#include<stdlib.h>

#include "Sort.h"

int main() {

    int array[] = {38, 27, 43, 3, 9, 82, 10};
    int n = sizeof(array) / sizeof(array[0]);

    merge_sort(array, 0, n - 1);

    printf("Merge Sort: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}