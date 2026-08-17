#include <stdlib.h>

int cmp(const void *a, const void *b) {
    int *x = *(int **)a;
    int *y = *(int **)b;
    return x[0] - y[0];
}

void swap(int *a, int *b) {
    int t = *a;
    *a = *b;
    *b = t;
}

// Insert into min-heap
void push(int heap[], int *size, int val) {
    int i = (*size)++;
    heap[i] = val;

    while (i > 0) {
        int p = (i - 1) / 2;
        if (heap[p] <= heap[i])
            break;
        swap(&heap[p], &heap[i]);
        i = p;
    }
}

// Remove minimum
void pop(int heap[], int *size) {
    heap[0] = heap[--(*size)];

    int i = 0;
    while (1) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;

        if (l < *size && heap[l] < heap[smallest])
            smallest = l;

        if (r < *size && heap[r] < heap[smallest])
            smallest = r;

        if (smallest == i)
            break;

        swap(&heap[i], &heap[smallest]);
        i = smallest;
    }
}

int minMeetingRooms(int **intervals, int intervalsSize, int *intervalsColSize) {

    if (intervalsSize == 0)
        return 0;

    qsort(intervals, intervalsSize, sizeof(int *), cmp);

    int *heap = (int *)malloc(intervalsSize * sizeof(int));
    int heapSize = 0;

    push(heap, &heapSize, intervals[0][1]);

    for (int i = 1; i < intervalsSize; i++) {

        if (heap[0] <= intervals[i][0])
            pop(heap, &heapSize);

        push(heap, &heapSize, intervals[i][1]);
    }

    free(heap);

    return heapSize;
}
