// Problem 2 
// Highest Temperature in Every Time Window 

#include <stdio.h>
#define MAX 100000

typedef struct {
    int arr[MAX];
    int front;
    int rear;
} Deque;

void initialize(Deque *q) {
    q->front = 0;
    q->rear = -1;
}

void pushBack(Deque *q, int val) {
    q->arr[++q->rear] = val;
}

void popFront(Deque *q) {
    q->front++;
}
 
void popBack(Deque *q) {
    q->rear--;
}

int getFront(Deque *q) {
    return q->arr[q->front];
}

int getBack(Deque *q) {
    return q->arr[q->rear];
}

int isEmpty(Deque *q) {
    if (q->front > q->rear)
        return 1;
    return 0;
}

void maxTemperature(int a[], int n, int k) {
    Deque q;
    initialize(&q);

    int ans[MAX];
    int size = 0;

    for (int i = 0; i < n; i++) {
        while (isEmpty(&q) == 0) {
            if (getFront(&q) <= i - k)
                popFront(&q);
            else
                break;
        }

        while (isEmpty(&q) == 0) {
            if (a[getBack(&q)] <= a[i])
                popBack(&q);
            else
                break;
        }

        pushBack(&q, i);

        if (i >= k - 1) {
            ans[size] = a[getFront(&q)];
            size++;
        }
    }

    for (int i = 0; i < size; i++) {
        printf("%d ", ans[i]);
    }
}

int main() {
    int n;

    printf("Enter size: ");
    scanf("%d", &n);

    int a[MAX];

    printf("Enter temperatures: ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    int k;

    printf("Enter window size: ");
    scanf("%d", &k);

    maxTemperature(a, n, k);

    return 0;
}