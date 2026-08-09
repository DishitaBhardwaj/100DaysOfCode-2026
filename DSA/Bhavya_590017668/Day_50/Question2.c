#include <stdlib.h>

void swap(int *a, int *b) {
    int t = *a;
    *a = *b;
    *b = t;
}

void heapifyUp(int heap[], int index) {
    while (index > 0) {
        int parent = (index - 1) / 2;
        if (heap[parent] >= heap[index])
            break;
        swap(&heap[parent], &heap[index]);
        index = parent;
    }
}

void heapifyDown(int heap[], int size, int index) {
    while (1) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && heap[left] > heap[largest])
            largest = left;
        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest == index)
            break;

        swap(&heap[index], &heap[largest]);
        index = largest;
    }
}

void push(int heap[], int *size, int value) {
    heap[*size] = value;
    (*size)++;
    heapifyUp(heap, *size - 1);
}

int pop(int heap[], int *size) {
    int top = heap[0];
    heap[0] = heap[*size - 1];
    (*size)--;
    heapifyDown(heap, *size, 0);
    return top;
}

int lastStoneWeight(int* stones, int stonesSize) {
    if (stonesSize == 0)
        return 0;

    int *heap = (int *)malloc(stonesSize * sizeof(int));
    int size = 0;

    for (int i = 0; i < stonesSize; i++)
        push(heap, &size, stones[i]);

    while (size > 1) {
        int y = pop(heap, &size);
        int x = pop(heap, &size);

        if (y != x)
            push(heap, &size, y - x);
    }

    int ans = (size == 0) ? 0 : heap[0];
    free(heap);
    return ans;
}