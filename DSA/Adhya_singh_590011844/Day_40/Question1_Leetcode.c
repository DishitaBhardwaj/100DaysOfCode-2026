#include <stdio.h>

#define MAX_SIZE 1005

typedef struct {
    int left[MAX_SIZE];
    int right[MAX_SIZE];

    int leftSize;
    int rightSize;
} FrontMiddleBackQueue;

void init(FrontMiddleBackQueue* q) {
    q->leftSize = 0;
    q->rightSize = 0;
}

void balance(FrontMiddleBackQueue* q) {

    while (q->leftSize > q->rightSize + 1) {
        q->right[q->rightSize++] =
            q->left[--q->leftSize];
    }

    while (q->leftSize < q->rightSize) {

        q->left[q->leftSize++] =
            q->right[0];

        for (int i = 0; i < q->rightSize - 1; i++)
            q->right[i] = q->right[i + 1];

        q->rightSize--;
    }
}

void pushFront(FrontMiddleBackQueue* q, int val) {

    for (int i = q->leftSize; i > 0; i--)
        q->left[i] = q->left[i - 1];

    q->left[0] = val;
    q->leftSize++;

    balance(q);
}

void pushMiddle(FrontMiddleBackQueue* q, int val) {

    if (q->leftSize > q->rightSize) {

        q->right[q->rightSize++] =
            q->left[q->leftSize - 1];

        q->left[q->leftSize - 1] = val;

    } else {
        q->left[q->leftSize++] = val;
    }
}

void pushBack(FrontMiddleBackQueue* q, int val) {

    q->right[q->rightSize++] = val;

    balance(q);
}

int popFront(FrontMiddleBackQueue* q) {

    if (q->leftSize == 0 && q->rightSize == 0)
        return -1;

    int value = q->left[0];

    for (int i = 0; i < q->leftSize - 1; i++)
        q->left[i] = q->left[i + 1];

    q->leftSize--;

    balance(q);

    return value;
}

int popMiddle(FrontMiddleBackQueue* q) {

    if (q->leftSize == 0 && q->rightSize == 0)
        return -1;

    int value = q->left[q->leftSize - 1];

    q->leftSize--;

    balance(q);

    return value;
}

int popBack(FrontMiddleBackQueue* q) {

    if (q->leftSize == 0 && q->rightSize == 0)
        return -1;

    int value;

    if (q->rightSize > 0) {
        value = q->right[q->rightSize - 1];
        q->rightSize--;
    } else {
        value = q->left[q->leftSize - 1];
        q->leftSize--;
    }

    balance(q);

    return value;
}

void printQueue(FrontMiddleBackQueue* q) {

    printf("Queue: ");

    for (int i = 0; i < q->leftSize; i++)
        printf("%d ", q->left[i]);

    for (int i = 0; i < q->rightSize; i++)
        printf("%d ", q->right[i]);

    printf("\n");
}

int main() {

    FrontMiddleBackQueue q;

    init(&q);

    pushFront(&q, 1);
    pushBack(&q, 2);
    pushBack(&q, 3);
    pushBack(&q, 4);
    pushBack(&q, 5);

    printQueue(&q);

    pushMiddle(&q, 6);
    printQueue(&q);

    printf("Pop Middle: %d\n", popMiddle(&q));
    printQueue(&q);

    printf("Pop Front: %d\n", popFront(&q));
    printQueue(&q);

    printf("Pop Back: %d\n", popBack(&q));
    printQueue(&q);

    return 0;
}