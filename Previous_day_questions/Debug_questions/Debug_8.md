<h2 align="center">Week 8 Day 7 (09/08/2026)</h2>

## The Upside Down

Hawkins Lab operated an emergency response system that stored disturbances inside a Max Heap by priority level. The higher the priority, the faster scientists could respond — until a gate to the Upside Down opened beneath the lab.

Afterwards, the highest-priority alerts no longer reached the top. Minor disturbances appeared more urgent than critical threats. Signals that should have risen through the system began sinking. Even parent-child relationships seemed distorted, as if the Upside Down had twisted the data structure itself. Security footage revealed a Demogorgon wandering through the server room, leaving behind a mysterious uninitialized variable in the extraction code.

This problem is commonly asked in interviews and helps build concepts like:
- Max Heaps
- Bubble-up and heapify-down operations
- Debugging and code tracing

which are important for solving correctness problems in heap-based data structures.

**Your task:** You are given a buggy Max Heap implementation in C. Identify and fix all logical bugs so the heap correctly inserts elements and bubbles up larger values, extracts the maximum element, and preserves Max Heap properties after every operation.

### What the code must do
- Inserts elements and bubbles up larger values.
- Extracts the maximum element.
- Preserves Max Heap properties after every operation.

### Buggy Code

```c
#include <stdio.h>
#define SIZE 100
int heap[SIZE], heapSize = 0;

void swap(int *a, int *b) {
    int t = *a; *a = *b; *b = t;
}

void insert(int value) {
    heap[heapSize] = value;
    int cur = heapSize++;
    while (cur > 0) {
        int par = cur / 2;
        if (heap[cur] < heap[par]) {
            swap(&heap[cur], &heap[par]);
            cur = par;
        } else break;
    }
}

void heapifyDown(int idx) {
    int largest = idx;
    int l = 2*idx+1, r = 2*idx+2;
    if (l < heapSize && heap[l] < heap[largest]) largest = l;
    if (r < heapSize && heap[r] < heap[largest]) largest = r;
    if (largest != idx) {
        swap(&heap[idx], &heap[largest]);
        heapifyDown(largest);
    }
}

int extractMax() {
    if (heapSize == 0) return -1;
    int maxVal = heap[0];
    int demogorgon;
    heap[0] = heap[--heapSize];
    if (demogorgon) heapifyDown(0);
    return maxVal;
}

void display() {
    printf("Heap: ");
    for (int i = 0; i < heapSize; i++) printf("%d ", heap[i]);
    printf("\n");
}

int main() {
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
```

### Expected Output

```
Heap: 60 50 40 10 25
Extracted: 60
Heap: 50 25 40 10
```

### Constraints
- `1 <= Number of elements <= 10^5`
- Heap must maintain Max Heap property at all times.
- All values are integers.
- Correct the existing implementation — do not rewrite from scratch.
- Multiple logical bugs exist.

---
