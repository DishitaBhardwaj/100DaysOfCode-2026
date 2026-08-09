#include <stdio.h>
#include <stdlib.h>

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

int lastStoneWeight(int stones[], int n) {
    int *heap = (int *)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
        heap[i] = stones[i];

    int size = n;

    for (int i = size / 2 - 1; i >= 0; i--)
        heapifyDown(heap, size, i);

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

int main() {
    int n;

    printf("Enter number of stones: ");
    scanf("%d", &n);

    int *stones = (int *)malloc(n * sizeof(int));

    printf("Enter stone weights:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &stones[i]);

    printf("Last Remaining Stone: %d\n", lastStoneWeight(stones, n));

    free(stones);

    return 0;
}