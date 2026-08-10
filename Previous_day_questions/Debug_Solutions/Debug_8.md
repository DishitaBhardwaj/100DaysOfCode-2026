<h2 align="center">Week 8 Day 56 (09/08/2026)</h2>

## 1. The Upside Down — Max Heap Bug Fix

### Bugs found in the original code

1. **`insert`**: the parent index was computed as `cur / 2`, which is wrong for a 0-indexed heap array. It needed to be `(cur - 1) / 2` — with the old formula, node `1`'s "parent" resolved to index `0` correctly by coincidence, but every other node computed the wrong parent, silently corrupting the heap shape as more elements were inserted.
2. **`insert`**: the bubble-up comparison was `if (heap[cur] < heap[par])`, which pushes the *smaller* value upward — that's min-heap behavior. For a max heap it needed to be `>`, so larger values rise toward the root.
3. **`heapifyDown`**: both child comparisons (`heap[l] < heap[largest]` and `heap[r] < heap[largest]`) had the same inversion — they picked the smaller child as "largest," sinking big values instead of small ones. Both needed to be `>`.
4. **`extractMax`**: `int demogorgon;` was declared but never initialized, then used directly as the condition for whether to re-heapify (`if (demogorgon) heapifyDown(0);`). This is undefined behavior — the heap would restore its max-heap property only by chance, whenever that garbage value happened to be nonzero. The fix removes the stray variable entirely and always calls `heapifyDown(0)` after moving the last element to the root (this is provably safe even when the heap becomes empty, since the child-index bounds checks inside `heapifyDown` prevent any out-of-range access).

### Solution

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
        int par = (cur - 1) / 2;              // fixed: correct parent index for 0-indexed heap
        if (heap[cur] > heap[par]) {           // fixed: bubble up the LARGER value in a max heap
            swap(&heap[cur], &heap[par]);
            cur = par;
        } else break;
    }
}

void heapifyDown(int idx) {
    int largest = idx;
    int l = 2 * idx + 1, r = 2 * idx + 2;

    if (l < heapSize && heap[l] > heap[largest]) largest = l;  // fixed: max heap needs '>'
    if (r < heapSize && heap[r] > heap[largest]) largest = r;  // fixed: max heap needs '>'

    if (largest != idx) {
        swap(&heap[idx], &heap[largest]);
        heapifyDown(largest);
    }
}

int extractMax() {
    if (heapSize == 0) return -1;

    int maxVal = heap[0];
    heap[0] = heap[--heapSize];
    heapifyDown(0);                              // fixed: removed uninitialized `demogorgon`, always re-heapify

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

### Output

```
Heap: 60 50 40 10 25 
Extracted: 60
Heap: 50 25 40 10 
```

Matches the expected output exactly. Every insertion correctly bubbles the new value up toward the root when it's larger than its parent, and `extractMax` always restores the max-heap property afterward by sinking the replacement root value down through `heapifyDown`.

Complexity: O(log n) time per `insert` and per `extractMax`, O(1) extra space (heap stored in a fixed array).
