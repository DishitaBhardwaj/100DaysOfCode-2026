#include <stdio.h>

#define MAX 1000

struct FrontMiddleBack {
    int arr[MAX];
    int size;
};

void init(struct FrontMiddleBack *q) {
    q->size = 0;
}

void pushFront(struct FrontMiddleBack *q, int val) {
    for (int i = q->size; i > 0; i--)
        q->arr[i] = q->arr[i - 1];

    q->arr[0] = val;
    q->size++;
}

void pushMiddle(struct FrontMiddleBack *q, int val) {
    int mid = q->size / 2;

    for (int i = q->size; i > mid; i--)
        q->arr[i] = q->arr[i - 1];

    q->arr[mid] = val;
    q->size++;
}

void pushBack(struct FrontMiddleBack *q, int val) {
    q->arr[q->size++] = val;
}

int popFront(struct FrontMiddleBack *q) {

    if (q->size == 0)
        return -1;

    int val = q->arr[0];

    for (int i = 0; i < q->size - 1; i++)
        q->arr[i] = q->arr[i + 1];

    q->size--;

    return val;
}

int popMiddle(struct FrontMiddleBack *q) {

    if (q->size == 0)
        return -1;

    int mid = (q->size - 1) / 2;
    int val = q->arr[mid];

    for (int i = mid; i < q->size - 1; i++)
        q->arr[i] = q->arr[i + 1];

    q->size--;

    return val;
}

int popBack(struct FrontMiddleBack *q) {

    if (q->size == 0)
        return -1;

    return q->arr[--q->size];
}

void display(struct FrontMiddleBack *q) {
    for (int i = 0; i < q->size; i++)
        printf("%d ", q->arr[i]);
    printf("\n");
}

int main() {

    struct FrontMiddleBack q;
    init(&q);

    pushFront(&q, 1);
    pushBack(&q, 2);
    pushMiddle(&q, 3);
    pushMiddle(&q, 4);

    display(&q);

    printf("popFront: %d\n", popFront(&q));
    printf("popMiddle: %d\n", popMiddle(&q));
    printf("popMiddle: %d\n", popMiddle(&q));
    printf("popBack: %d\n", popBack(&q));
    printf("popFront: %d\n", popFront(&q));

    return 0;
}