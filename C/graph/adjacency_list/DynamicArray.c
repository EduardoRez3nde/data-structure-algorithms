#include "DynamicArray.h"

DynamicArray* createArray(int initialCapacity) {
    DynamicArray* arr = (DynamicArray*) malloc(sizeof(DynamicArray));
    arr->data = (int*) malloc(initialCapacity * sizeof(int));
    arr->size = 0;
    arr->capacity = initialCapacity;
    return arr;
}

int contains(DynamicArray* array, int value) {
    for (int i = 0; i < array->size; i++) {
        if (array->data[i] == value) {
            return 1; // encontrado
        }
    }
    return 0; // não encontrado
}

void add(DynamicArray* arr, int value) {
    if (arr->size == arr->capacity) {
        // Dobrar capacidade se necessário
        arr->capacity *= 2;
        arr->data = (int*) realloc(arr->data, arr->capacity * sizeof(int));
    }
    arr->data[arr->size++] = value;
}

void del(DynamicArray* arr, int index) {
    if (index < 0 || index >= arr->size) {
        printf("Índice inválido!\n");
        return;
    }
    // Move os elementos após o índice uma posição para trás
    for (int i = index; i < arr->size - 1; i++) {
        arr->data[i] = arr->data[i + 1];
    }
    arr->size--;
}

void printArray(DynamicArray* arr) {
    printf("Array: ");
    for (int i = 0; i < arr->size; i++) {
        printf("%d ", arr->data[i]);
    }
    printf("\n");
}

void freeArray(DynamicArray* arr) {
    free(arr->data);
    free(arr);
}


