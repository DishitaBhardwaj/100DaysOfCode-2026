#include <stdio.h>
#define MAX 1000

typedef struct {
    int arr[MAX];
    int size;
} FrontMiddleBackQueue;

void init(FrontMiddleBackQueue *q) {
    q->size = 0;
}

void pushFront(FrontMiddleBackQueue *q, int val) {
    for (int i = q->size; i > 0; i--)
        q->arr[i] = q->arr[i - 1];
    q->arr[0] = val;
    q->size++;
}

void pushMiddle(FrontMiddleBackQueue *q, int val) {
    int mid = q->size / 2;
    for (int i = q->size; i > mid; i--)
        q->arr[i] = q->arr[i - 1];
    q->arr[mid] = val;
    q->size++;
}

void pushBack(FrontMiddleBackQueue *q, int val) {
    q->arr[q->size++] = val;
}

int popFront(FrontMiddleBackQueue *q) {
    if (q->size == 0)
        return -1;

    int val = q->arr[0];
    for (int i = 0; i < q->size - 1; i++)
        q->arr[i] = q->arr[i + 1];
    q->size--;
    return val;
}

int popMiddle(FrontMiddleBackQueue *q) {
    if (q->size == 0)
        return -1;

    int mid = (q->size - 1) / 2;
    int val = q->arr[mid];

    for (int i = mid; i < q->size - 1; i++)
        q->arr[i] = q->arr[i + 1];
    q->size--;

    return val;
}

int popBack(FrontMiddleBackQueue *q) {
    if (q->size == 0)
        return -1;

    return q->arr[--q->size];
}

int main() {
    FrontMiddleBackQueue q;
    init(&q);

    pushFront(&q, 1);      
    pushBack(&q, 2);       
    pushMiddle(&q, 3);     
    pushMiddle(&q, 4);     

    printf("%d\n", popFront(&q));   
    printf("%d\n", popMiddle(&q));  
    printf("%d\n", popMiddle(&q));  
    printf("%d\n", popBack(&q));    
    printf("%d\n", popFront(&q));   

    return 0;
}