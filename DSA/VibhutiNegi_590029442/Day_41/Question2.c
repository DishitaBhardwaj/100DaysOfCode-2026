#include <stdio.h>
#include <string.h>
#define MAX 10000
typedef struct {
    int arr[MAX];
    int front, rear;
} Queue;
void init(Queue *q) {
    q->front = 0;
    q->rear = -1;
}
int isEmpty(Queue *q) {
    return q->front > q->rear;
}
void enqueue(Queue *q, int x) {
    q->arr[++q->rear] = x;
}
int dequeue(Queue *q) {
    return q->arr[q->front++];
}
int main() {
    char jobs[MAX + 1];
    printf("Enter jobs string: ");
    scanf("%s", jobs);
    int n = strlen(jobs);
    Queue sales, marketing;
    init(&sales);
    init(&marketing);
    for (int i = 0; i < n; i++) {
        if (jobs[i] == 'S')
            enqueue(&sales, i);
        else
            enqueue(&marketing, i);
    }
    while (!isEmpty(&sales) && !isEmpty(&marketing)) {
        int s = dequeue(&sales);
        int m = dequeue(&marketing);
        if (s < m)
            enqueue(&sales, s + n);
        else
            enqueue(&marketing, m + n);
    }
    if (!isEmpty(&sales))
        printf("Sales\n");
    else
        printf("Marketing\n");
    return 0;
}