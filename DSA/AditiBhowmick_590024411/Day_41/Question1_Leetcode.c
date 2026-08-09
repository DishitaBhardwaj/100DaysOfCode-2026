#include <stdio.h>
#include <stdbool.h>
#define MAX 1000

typedef struct {
    int arr[MAX];
    int front;
    int rear;
    int size;
    int capacity;
} MyCircularQueue;

void init(MyCircularQueue *q, int k) {
    q->front = 0;
    q->rear = -1;
    q->size = 0;
    q->capacity = k;
}

bool isEmpty(MyCircularQueue *q) {
    return q->size == 0;
}

bool isFull(MyCircularQueue *q) {
    return q->size == q->capacity;
}

bool enQueue(MyCircularQueue *q, int value) {
    if (isFull(q))
        return false;

    q->rear = (q->rear + 1) % q->capacity;
    q->arr[q->rear] = value;
    q->size++;
    return true;
}

bool deQueue(MyCircularQueue *q) {
    if (isEmpty(q))
        return false;

    q->front = (q->front + 1) % q->capacity;
    q->size--;

    return true;
}

int Front(MyCircularQueue *q) {
    if (isEmpty(q))
        return -1;

    return q->arr[q->front];
}

int Rear(MyCircularQueue *q) {
    if (isEmpty(q))
        return -1;

    return q->arr[q->rear];
}

int main() {
    MyCircularQueue q;
    init(&q, 3);

    printf("%s\n", enQueue(&q, 1) ? "true" : "false");
    printf("%s\n", enQueue(&q, 2) ? "true" : "false");
    printf("%s\n", enQueue(&q, 3) ? "true" : "false");
    printf("%s\n", enQueue(&q, 4) ? "true" : "false");

    printf("%d\n", Rear(&q));
    printf("%s\n", isFull(&q) ? "true" : "false");

    printf("%s\n", deQueue(&q) ? "true" : "false");

    printf("%s\n", enQueue(&q, 4) ? "true" : "false");

    printf("%d\n", Rear(&q));

    return 0;
}