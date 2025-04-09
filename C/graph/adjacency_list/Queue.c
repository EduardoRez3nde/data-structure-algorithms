#include <stdio.h>
#include <stdlib.h>

#include "Queue.h"

// Função para criar uma fila vazia
Queue* createQueue() {
    Queue* q = (Queue*)malloc(sizeof(Queue));
    q->front = q->rear = NULL;
    return q;
}

int isEmpty(Queue* q) {
    return (q->front == NULL);
}

// Função para enfileirar um elemento (enqueue)
void enqueue(Queue* q, int value) {
    Node* temp = (Node*)malloc(sizeof(Node));
    temp->element = value;
    temp->next = NULL;

    if (q->rear == NULL) {
        q->front = q->rear = temp;
        return;
    }

    q->rear->next = temp;
    q->rear = temp;
}

// Função para desenfileirar um elemento (dequeue)
int dequeue(Queue* q) {
    if (q->front == NULL) {
        printf("Fila vazia!\n");
        return -1; // Código de erro
    }

    Node* temp = q->front;
    int value = temp->element;
    q->front = q->front->next;

    // Se a fila ficou vazia, rear também deve ser NULL
    if (q->front == NULL)
        q->rear = NULL;

    free(temp);
    return value;
}

// Função para imprimir os elementos da fila
void printQueue(Queue* q) {
    Node* temp = q->front;
    printf("Fila: ");
    while (temp != NULL) {
        printf("%d ", temp->element);
        temp = temp->next;
    }
    printf("\n");
}
