#include <stdio.h>
#define SIZE 100  // ERROR -> The constraint states 1 ≤ Number of elements ≤ 10^5, but the heap SIZE is only 100, so either the SIZE needs to be increased or there should be condition to check if the heap is full while inserting to prevent overflow. But as the PDF states that the structure doesn't have to be changed, I am not changing anything, just stating down the error.
int heap[SIZE], heapSize = 0;

void swap(int *a, int *b) { int t = *a; *a = *b; *b = t; }

void insert(int value) {
    heap[heapSize] = value;
    int cur = heapSize++;
    while (cur > 0) {
        // Fix 1 -> Corrected parent index calculation for 0 indexed Array
        int par = (cur - 1) / 2;

        // Fix 2 -> Changed the comparision symbol from '<' to '>' so that larger values bubble up in the MaxHeap
        if (heap[cur] > heap[par]) {
            swap(&heap[cur], &heap[par]); cur = par;
        } else break;
    }
}

void heapifyDown(int idx) {
    int largest = idx;
    int l = 2*idx+1, r = 2*idx+2;
    if (l < heapSize && heap[l] > heap[largest]) largest = l; // Fix 3 -> Changed the second condition comparator to '>' from '<' so that the Left child comparision is correct.
    if (r < heapSize && heap[r] > heap[largest]) largest = r; // Fix 4 -> Changed the second condition comparator to '>' from '<' so that the Right child comparision is correct.
    if (largest != idx) { swap(&heap[idx], &heap[largest]); heapifyDown(largest); }
}

int extractMax() {
    if (heapSize == 0) return -1;
    int maxVal = heap[0];
    // Fix 5 -> Removed the uninitialized demorgan variable
    heap[0] = heap[--heapSize];

    // Fix 6 -> Restore the heap structure if elements remain
    if (heapSize>0) heapifyDown(0);  
    return maxVal;
}

void display() {
    printf("Heap: ");
    for (int i = 0; i < heapSize; i++) printf("%d ", heap[i]);
    printf("\n");
}

int main() {
    insert(40); insert(25); insert(50); insert(10); insert(60);
    display();
    printf("Extracted: %d\n", extractMax());
    display();
    return 0;
}