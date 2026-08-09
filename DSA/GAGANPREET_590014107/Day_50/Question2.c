#include <stdio.h>
#include <stdlib.h>

// Max Heap Functions
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void heapifyDown(int heap[], int size, int i) {
    while (1) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest == i)
            break;

        swap(&heap[i], &heap[largest]);
        i = largest;
    }
}

void heapifyUp(int heap[], int i) {
    while (i > 0) {
        int parent = (i - 1) / 2;

        if (heap[parent] >= heap[i])
            break;

        swap(&heap[parent], &heap[i]);
        i = parent;
    }
}

void insert(int heap[], int *size, int value) {
    heap[*size] = value;
    heapifyUp(heap, *size);
    (*size)++;
}

int extractMax(int heap[], int *size) {
    int max = heap[0];
    heap[0] = heap[*size - 1];
    (*size)--;
    heapifyDown(heap, *size, 0);
    return max;
}

int lastStoneWeight(int *stones, int stonesSize) {
    int heap[1005];
    int size = 0;

    for (int i = 0; i < stonesSize; i++)
        insert(heap, &size, stones[i]);

    while (size > 1) {
        int x = extractMax(heap, &size);
        int y = extractMax(heap, &size);

        if (x != y)
            insert(heap, &size, x - y);
    }

    return (size == 0) ? 0 : heap[0];
}


int main() {
    int stones[] = {2, 7, 4, 1, 8, 1};
    int n = sizeof(stones) / sizeof(stones[0]);

    int ans = lastStoneWeight(stones, n);

    printf("Last Stone Weight = %d\n", ans);

    return 0;
}
