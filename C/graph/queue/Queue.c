#include <stdio.h>
#include <stdlib.h>

#include "Queue.h"

// Inicializa a fila
Queue* create_queue() {
    Queue* q = malloc(sizeof(Queue));
    q->front = q->rear = NULL;
    return q;
}

int isEmpty(Queue* q) {
    return q->front == -1;
}

// Adiciona um elemento à fila
void enqueue(Queue* q, int value) {
    Node* new_node = malloc(sizeof(Node));
    new_node->data = value;
    new_node->next = NULL;

    if (q->rear == NULL) {
        q->front = q->rear = new_node;
        return;
    }

    q->rear->next = new_node;
    q->rear = new_node;
}

// Remove um elemento da fila
int dequeue(Queue* q) {
    if (q->front == NULL) {
        printf("Fila vazia!\n");
        return -1; // ou outra forma de indicar erro
    }

    Node* temp = q->front;
    int value = temp->data;
    q->front = q->front->next;

    if (q->front == NULL)
        q->rear = NULL;

    free(temp);
    return value;
}

// Imprime a fila
void print_queue(Queue* q) {
    Node* current = q->front;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}
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
Queue* create_queue() {
    Queue* q = malloc(sizeof(Queue));
    q->front = q->rear = NULL;
    return q;
}

// Adiciona um elemento à fila
void enqueue(Queue* q, int value) {
    Node* new_node = malloc(sizeof(Node));
    new_node->data = value;
    new_node->next = NULL;

    if (q->rear == NULL) {
        q->front = q->rear = new_node;
        return;
    }

    q->rear->next = new_node;
    q->rear = new_node;
}

// Remove um elemento da fila
int dequeue(Queue* q) {
    if (q->front == NULL) {
        printf("Fila vazia!\n");
        return -1; // ou outra forma de indicar erro
    }

    Node* temp = q->front;
    int value = temp->data;
    q->front = q->front->next;

    if (q->front == NULL)
        q->rear = NULL;

    free(temp);
    return value;
}

// Imprime a fila
void print_queue(Queue* q) {
    Node* current = q->front;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}
