#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int *arr;
    int front;
    int rear;
    int size;
    int capacity;
} MyCircularQueue;

MyCircularQueue* createQueue(int k) {
    MyCircularQueue* q =
        (MyCircularQueue*)malloc(sizeof(MyCircularQueue));

    q->arr = (int*)malloc(k * sizeof(int));
    q->front = 0;
    q->rear = 0;
    q->size = 0;
    q->capacity = k;

    return q;
}

bool enQueue(MyCircularQueue* q, int value) {
    if (q->size == q->capacity)
        return false;

    q->arr[q->rear] = value;

    q->rear = (q->rear + 1) % q->capacity;
    q->size++;

    return true;
}

bool deQueue(MyCircularQueue* q) {
    if (q->size == 0)
        return false;

    q->front = (q->front + 1) % q->capacity;
    q->size--;

    return true;
}

int Front(MyCircularQueue* q) {
    if (q->size == 0)
        return -1;

    return q->arr[q->front];
}

int Rear(MyCircularQueue* q) {
    if (q->size == 0)
        return -1;

    int index = (q->rear - 1 + q->capacity)
                % q->capacity;

    return q->arr[index];
}

bool isEmpty(MyCircularQueue* q) {
    return q->size == 0;
}

bool isFull(MyCircularQueue* q) {
    return q->size == q->capacity;
}

void freeQueue(MyCircularQueue* q) {
    free(q->arr);
    free(q);
}

int main() {
    int k;

    printf("Enter queue capacity: ");
    scanf("%d", &k);

    MyCircularQueue* q = createQueue(k);

    printf("\nEnqueue 10: %s\n",
           enQueue(q, 10) ? "true" : "false");

    printf("Enqueue 20: %s\n",
           enQueue(q, 20) ? "true" : "false");

    printf("Enqueue 30: %s\n",
           enQueue(q, 30) ? "true" : "false");

    printf("Front: %d\n", Front(q));
    printf("Rear: %d\n", Rear(q));

    printf("Is Full: %s\n",
           isFull(q) ? "true" : "false");

    printf("\nDequeue: %s\n",
           deQueue(q) ? "true" : "false");

    printf("Enqueue 40: %s\n",
           enQueue(q, 40) ? "true" : "false");

    printf("Front: %d\n", Front(q));
    printf("Rear: %d\n", Rear(q));

    printf("Is Empty: %s\n",
           isEmpty(q) ? "true" : "false");

    freeQueue(q);

    return 0;
}