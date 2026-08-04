/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

typedef struct {
    int val;
    int idx;
} Node;

void swap(Node *a, Node *b) {
    Node temp = *a;
    *a = *b;
    *b = temp;
}

void heapifyUp(Node heap[], int index) {
    while (index > 0) {
        int parent = (index - 1) / 2;

        if (heap[parent].val > heap[index].val ||
           (heap[parent].val == heap[index].val &&
            heap[parent].idx > heap[index].idx)) {

            swap(&heap[parent], &heap[index]);
            index = parent;
        } else {
            break;
        }
    }
}

void heapifyDown(Node heap[], int size, int index) {
    while (1) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size &&
            (heap[left].val < heap[smallest].val ||
            (heap[left].val == heap[smallest].val &&
             heap[left].idx < heap[smallest].idx))) {
            smallest = left;
        }

        if (right < size &&
            (heap[right].val < heap[smallest].val ||
            (heap[right].val == heap[smallest].val &&
             heap[right].idx < heap[smallest].idx))) {
            smallest = right;
        }

        if (smallest != index) {
            swap(&heap[index], &heap[smallest]);
            index = smallest;
        } else {
            break;
        }
    }
}

int* getFinalState(int* nums, int numsSize, int k, int multiplier, int* returnSize) {
    Node heap[10005];
    int size = 0;

    // Build heap
    for (int i = 0; i < numsSize; i++) {
        heap[size].val = nums[i];
        heap[size].idx = i;
        heapifyUp(heap, size);
        size++;
    }

    while (k--) {
        Node cur = heap[0];

        cur.val *= multiplier;
        nums[cur.idx] = cur.val;

        heap[0] = cur;
        heapifyDown(heap, size, 0);
    }

    *returnSize = numsSize;
    return nums;
}
