// Problem 2 
// Office Printer Wars

#include <stdio.h>
#include <string.h>
#define MAX 10001

typedef struct {
    int queue[MAX];
    int front;
    int rear;
} Queue;

void enqueue(Queue *q, int value) {
    q->queue[q->rear] = value;
    q->rear++;
}

int dequeue(Queue *q) {
    int value = q->queue[q->front];
    q->front++;
    return value;
}

int empty(Queue *q) {
    if (q->front == q->rear)
        return 1;
    return 0;
}

void winner(char jobs[]) {
    Queue Sales;
    Queue Marketing;
    Sales.front = 0;
    Sales.rear = 0;
    Marketing.front = 0;
    Marketing.rear = 0;
    int n = strlen(jobs);
    for (int i = 0; i < n; i++) {
        if (jobs[i] == 'S')
            enqueue(&Sales, i);
        else
            enqueue(&Marketing, i);
    }

    while (empty(&Sales) == 0 && empty(&Marketing) == 0) {
        int s = dequeue(&Sales);
        int m = dequeue(&Marketing);
        if (s < m)
            enqueue(&Sales, s + n);
        else
            enqueue(&Marketing, m + n);
    }

    if (empty(&Sales))
        printf("Department that remains last: Marketing");
    else
        printf("Department that remains last: Sales");
}

int main() {
    char jobs[MAX];
    printf("Enter the jobs: ");
    scanf("%s", jobs);
    winner(jobs);
    return 0;
}