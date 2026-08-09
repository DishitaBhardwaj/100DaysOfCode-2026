#include <stdlib.h>

typedef struct {
    int value;
    int index;
} Node;

void swap(Node *a, Node *b) {
    Node t = *a;
    *a = *b;
    *b = t;
}

void push(Node heap[], int *size, Node x) {
    int i = (*size)++;
    heap[i] = x;

    while (i > 0) {
        int p = (i - 1) / 2;
        if (heap[p].value >= heap[i].value)
            break;
        swap(&heap[p], &heap[i]);
        i = p;
    }
}

void pop(Node heap[], int *size) {
    heap[0] = heap[--(*size)];

    int i = 0;

    while (1) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;

        if (l < *size && heap[l].value > heap[largest].value)
            largest = l;

        if (r < *size && heap[r].value > heap[largest].value)
            largest = r;

        if (largest == i)
            break;

        swap(&heap[i], &heap[largest]);
        i = largest;
    }
}

int* maxSlidingWindow(int* nums, int numsSize, int k, int* returnSize) {

    *returnSize = numsSize - k + 1;
    int *ans = (int *)malloc((*returnSize) * sizeof(int));

    Node *heap = (Node *)malloc(numsSize * sizeof(Node));
    int heapSize = 0;

    int idx = 0;

    for (int i = 0; i < numsSize; i++) {

        push(heap, &heapSize, (Node){nums[i], i});

        while (heapSize > 0 && heap[0].index <= i - k)
            pop(heap, &heapSize);

        if (i >= k - 1)
            ans[idx++] = heap[0].value;
    }

    free(heap);

    return ans;
}
