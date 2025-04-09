#ifndef QUEUE_H
#define QUEUE_H

#include <stdio.h>
#include <stdlib.h>

#include "AdjacencyList.h"

// Estrutura da fila
typedef struct Queue {
    Node* front;
    Node* rear;
} Queue;

// Função para criar uma fila vazia
Queue* createQueue();

// Função para enfileirar um elemento (enqueue)
void enqueue(Queue* q, int value);

// Função para desenfileirar um elemento (dequeue)
int dequeue(Queue* q);

// Função para imprimir os elementos da fila
void printQueue(Queue* q);

int isEmpty(Queue* q);

#endif