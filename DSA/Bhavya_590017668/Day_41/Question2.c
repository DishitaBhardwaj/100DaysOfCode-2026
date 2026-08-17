#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    char dept;
} Job;

typedef struct {
    Job *queue;
    int front, rear, size, capacity;
} CircularQueue;

CircularQueue* createQueue(int k) {
    CircularQueue* cq = (CircularQueue*) malloc(sizeof(CircularQueue));
    cq->queue = (Job*) malloc(sizeof(Job) * k);
    cq->capacity = k;
    cq->front = -1;
    cq->rear = -1;
    cq->size = 0;
    return cq;
}

bool enQueue(CircularQueue* cq, Job job) {
    if (cq->size == cq->capacity) return false;
    if (cq->size == 0) cq->front = 0;
    cq->rear = (cq->rear + 1) % cq->capacity;
    cq->queue[cq->rear] = job;
    cq->size++;
    return true;
}

bool deQueue(CircularQueue* cq) {
    if (cq->size == 0) return false;
    if (cq->front == cq->rear) {
        cq->front = -1;
        cq->rear = -1;
    } else {
        cq->front = (cq->front + 1) % cq->capacity;
    }
    cq->size--;
    return true;
}

char simulateWars(CircularQueue* cq) {
    while (cq->size > 1) {
        char processed = cq->queue[cq->front].dept;
        deQueue(cq);
        deQueue(cq);
        printf("Processed: %c, Eliminated next job\n", processed);
    }
    return cq->queue[cq->front].dept;
}

int main() {
    CircularQueue* cq = createQueue(6);
    enQueue(cq, (Job){'H'});
    enQueue(cq, (Job){'I'});
    enQueue(cq, (Job){'H'});
    enQueue(cq, (Job){'I'});
    enQueue(cq, (Job){'H'});
    enQueue(cq, (Job){'I'});

    char winner = simulateWars(cq);
    printf("Winner Department: %c\n", winner);

    free(cq->queue);
    free(cq);
    return 0;
}
