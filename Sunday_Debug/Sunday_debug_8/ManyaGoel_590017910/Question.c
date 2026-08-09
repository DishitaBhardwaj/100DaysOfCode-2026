#include <stdio.h>
#define SIZE 100000  // FIX: Increased size from 100 to support up to 10^5 elements
int heap[SIZE], heapSize = 0;

void swap(int *a, int *b) { 
    int t = *a; 
    *a = *b; 
    *b = t;
 
}

void insert(int value) {
    heap[heapSize] = value;
    int cur = heapSize++;
    while (cur > 0) {
    // FIX: Parent of index cur in a 0-based heap is (cur - 1)/2, Using cur / 2 gives the wrong parent for several nodes.
        int par = (cur - 1) / 2;
    // FIX:  Max Heap requires the child to be GREATER than its parent. heap[cur] < heap[par] would create a Min Heap instead.
        if (heap[cur] > heap[par]) {
            swap(&heap[cur], &heap[par]); 
            cur = par;
        } 
        else break;
    }
}

void heapifyDown(int idx) {
    int largest = idx;
    int l = 2*idx+1, 
    r = 2*idx+2;
    //FIX: For a Max Heap, we need to find the LARGEST child.Original used '<', which moves the smaller value upward and breaks the Max Heap property.
    if (l < heapSize && heap[l] > heap[largest]) largest = l;
    // FIX: Right child must also be compared using '>'.
    if (r < heapSize && heap[r] > heap[largest]) largest = r;
    if (largest != idx) { swap(&heap[idx], &heap[largest]); heapifyDown(largest); }
}

int extractMax() {
    if (heapSize == 0) return -1;
    int maxVal = heap[0];   
    // int demogorgon; FIX: Removed uninitialized variable 'demogorgon' which was not used and could lead to unpredictable behavior.
    heap[0] = heap[--heapSize];
    // FIX: The variable 'demogorgon' was uninitialized, so its value was unpredictable. Only heapify if elements are still present.
    if (heapSize > 0) heapifyDown(0);
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