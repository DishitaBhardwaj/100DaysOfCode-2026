#include <stdio.h>

#define SIZE 100

int heap[SIZE];
int heapSize = 0;

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void insert(int value)
{
    if (heapSize >= SIZE)
    {
        printf("Heap is full\n");
        return;
    }

    int cur = heapSize;
    heap[heapSize] = value;
    heapSize++;

    while (cur > 0)
    {
        int parent = (cur - 1) / 2;
        if (heap[cur] > heap[parent])
        {
            swap(&heap[cur], &heap[parent]);
            cur = parent;
        }
        else
        {
            break;
        }
    }
}

void heapifyDown(int idx)
{
    while (1)
    {
        int largest = idx;

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if (left < heapSize && heap[left] > heap[largest])
        {
            largest = left;
        }
        if (right < heapSize && heap[right] > heap[largest])
        {
            largest = right;
        }
        if (largest == idx)
        {
            break;
        }
        swap(&heap[idx], &heap[largest]);

        idx = largest;
    }
}

int extractMax()
{
    if (heapSize == 0)
    {
        printf("Heap is empty\n");
        return -1;
    }
    int maxValue = heap[0];
    heapSize--;
    heap[0] = heap[heapSize];
    if (heapSize > 0)
    {
        heapifyDown(0);
    }
    return maxValue;
}

void display()
{
    printf("Heap: ");
    for (int i = 0; i < heapSize; i++)
    {
        printf("%d ", heap[i]);
    }
    printf("\n");
}

int main()
{
    insert(40);
    insert(25);
    insert(50);
    insert(10);
    insert(60);
    display();
    printf("Extracted: %d\n", extractMax());
    display();
    return 0;
}