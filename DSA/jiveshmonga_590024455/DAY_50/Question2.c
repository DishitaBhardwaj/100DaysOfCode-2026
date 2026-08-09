#include <stdio.h>

void heapifyDown(int heap[], int size, int i) {
    int largest=i;
    int left=2*i+1;
    int right=2*i+2;
    if (left<size&&heap[left]>heap[largest])
        largest=left;
    if (right<size&&heap[right]>heap[largest])
        largest=right;
    if (largest!=i) 
    {
        int temp = heap[i];
        heap[i] = heap[largest];
        heap[largest]=temp;
        heapifyDown(heap,size,largest);
    }
}
void heapifyUp(int heap[], int i) 
{
    while (i > 0) {
        int parent = (i - 1) / 2;
        if (heap[parent] >= heap[i])
            break;

        int temp = heap[parent];
        heap[parent] = heap[i];
        heap[i] = temp;
        i = parent;
    }
}

void insert(int heap[], int *size, int value) {
    heap[*size] = value;
    (*size)++;
    heapifyUp(heap, *size - 1);
}

int extractMax(int heap[], int *size) {
    int max = heap[0];
    heap[0] = heap[*size - 1];
    (*size)--;
    heapifyDown(heap, *size, 0);
    return max;
}
int lastStoneWeight(int stones[], int n) 
{
    int heap[1000];
    int size = 0;
    for (int i=0;i<n;i++)
        insert(heap, &size, stones[i]);
    while (size>1) 
    {
        int x=extractMax(heap, &size);
        int y=extractMax(heap, &size);
        if (x!=y)
            insert(heap, &size, x - y);
    }
    return (size==0)?0:heap[0];
}
int main()
{
    int stones[] = {2,7,4,1,8,1};
    int n=sizeof(stones)/sizeof(stones[0]);
    printf("%d\n", lastStoneWeight(stones, n));
    return 0;
}