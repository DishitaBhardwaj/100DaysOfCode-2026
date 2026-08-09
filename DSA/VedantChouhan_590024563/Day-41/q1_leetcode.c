#include <stdio.h>
#include <stdlib.h>

struct MyCircularQueue {
    int *arr;
    int front;
    int rear;
    int count;
    int capacity;
};

void initQueue(struct MyCircularQueue *q, int k) {
    q->arr = (int *)malloc(k * sizeof(int));
    q->capacity = k;
    q->front = 0;
    q->rear = -1;
    q->count = 0;
}

int enQueue(struct MyCircularQueue *q, int value) {

    if (q->count == q->capacity)
        return 0;

    q->rear = (q->rear + 1) % q->capacity;
    q->arr[q->rear] = value;
    q->count++;

    return 1;
}

int deQueue(struct MyCircularQueue *q) {

    if (q->count == 0)
        return 0;

    q->front = (q->front + 1) % q->capacity;
    q->count--;

    return 1;
}

int Front(struct MyCircularQueue *q) {

    if (q->count == 0)
        return -1;

    return q->arr[q->front];
}

int Rear(struct MyCircularQueue *q) {

    if (q->count == 0)
        return -1;

    return q->arr[q->rear];
}

int isEmpty(struct MyCircularQueue *q) {
    return q->count == 0;
}

int isFull(struct MyCircularQueue *q) {
    return q->count == q->capacity;
}

int main() {

    struct MyCircularQueue q;
    initQueue(&q, 3);

    printf("%d\n", enQueue(&q, 1));
    printf("%d\n", enQueue(&q, 2));
    printf("%d\n", enQueue(&q, 3));
    printf("%d\n", enQueue(&q, 4));

    printf("Rear: %d\n", Rear(&q));
    printf("Full: %s\n", isFull(&q) ? "true" : "false");

    printf("%d\n", deQueue(&q));
    printf("%d\n", enQueue(&q, 4));

    printf("Rear: %d\n", Rear(&q));
    printf("Front: %d\n", Front(&q));

    free(q.arr);

    return 0;
}