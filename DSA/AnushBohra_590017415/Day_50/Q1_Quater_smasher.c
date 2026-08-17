#include <stdio.h>
#include <stdlib.h>


void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void maxHeapify(int heap[], int size, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < size && heap[left] > heap[largest])
        largest = left;
    if (right < size && heap[right] > heap[largest])
        largest = right;

    if (largest != i) {
        swap(&heap[i], &heap[largest]);
        maxHeapify(heap, size, largest);
    }
}

void insertHeap(int heap[], int* size, int val) {
    heap[*size] = val;
    int i = *size;
    (*size)++;

    while (i != 0 && heap[(i - 1) / 2] < heap[i]) {
        swap(&heap[i], &heap[(i - 1) / 2]);
        i = (i - 1) / 2;
    }
}

int extractMax(int heap[], int* size) {
    if (*size <= 0) return 0;
    if (*size == 1) {
        (*size)--;
        return heap[0];
    }

    int root = heap[0];
    heap[0] = heap[*size - 1];
    (*size)--;
    maxHeapify(heap, *size, 0);

    return root;
}


int lastStoneWeight(int* rocks, int rocksSize) {
    int* heap = (int*)malloc(rocksSize * sizeof(int));
    int heapSize = 0;

    // Build the Max Heap
    for (int i = 0; i < rocksSize; i++) {
        insertHeap(heap, &heapSize, rocks[i]);
    }

    // Repeatedly smash the two heaviest rocks
    while (heapSize > 1) {
        int y = extractMax(heap, &heapSize); // Heaviest
        int x = extractMax(heap, &heapSize); // Second heaviest

        if (y != x) {
            insertHeap(heap, &heapSize, y - x);
        }
    }

    int result = (heapSize == 1) ? extractMax(heap, &heapSize) : 0;
    free(heap);
    return result;
}


int main(void) {
    int rocks[] = {2, 7, 4, 1, 8, 1};
    int rocksSize = sizeof(rocks) / sizeof(rocks[0]);

    int result = lastStoneWeight(rocks, rocksSize);

    printf("Remaining Rock Weight: %d\n", result);

    return 0;
}