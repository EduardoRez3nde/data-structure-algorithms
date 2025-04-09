#ifndef DYNAMIC_ARRAY_H
#define DYNAMIC_ARRAY_H

#include <stdio.h>
#include <stdlib.h>

// Struct da ADT
typedef struct {
    int* data;      // Ponteiro para os dados
    int size;       // Número atual de elementos
    int capacity;   // Capacidade total alocada
} DynamicArray;

DynamicArray* createArray(int initialCapacity);

void add(DynamicArray* arr, int value);

void del(DynamicArray* arr, int index);

void printArray(DynamicArray* arr);

void freeArray(DynamicArray* arr);

int contains(DynamicArray* array, int value);

#endif