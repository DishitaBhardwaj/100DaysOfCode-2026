#include <stdlib.h>

void heapify(int heap[], int n, int i)
{
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && heap[left] > heap[largest])
        largest = left;

    if (right < n && heap[right] > heap[largest])
        largest = right;

    if (largest != i)
    {
        int temp = heap[i];
        heap[i] = heap[largest];
        heap[largest] = temp;

        heapify(heap, n, largest);
    }
}

int lastStoneWeight(int* stones, int stonesSize)
{
    // Build Max Heap
    for (int i = stonesSize / 2 - 1; i >= 0; i--)
        heapify(stones, stonesSize, i);

    int size = stonesSize;

    while (size > 1)
    {
        int first = stones[0];

        stones[0] = stones[size - 1];
        size--;
        heapify(stones, size, 0);

        int second = stones[0];

        stones[0] = stones[size - 1];
        size--;
        heapify(stones, size, 0);

        if (first != second)
        {
            stones[size] = first - second;
            size++;

            for (int i = size / 2 - 1; i >= 0; i--)
                heapify(stones, size, i);
        }
    }

    if (size == 0)
        return 0;

    return stones[0];
}