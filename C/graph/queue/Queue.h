#include <stdio.h>
#include <stdlib.h>

// Estrutura do nó da fila
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Estrutura da fila
typedef struct Queue {
    Node* front;
    Node* rear;
} Queue;

// Inicializa a fila
Queue* create_queue();

// Adiciona um elemento à fila
void enqueue(Queue* q, int value);

// Remove um elemento da fila
int dequeue(Queue* q);

// Imprime a fila
void print_queue(Queue* q);

int isEmpty(Queue* q);