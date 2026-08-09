#include <stdio.h>
void heapify(int heap[], int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < n && heap[left] > heap[largest])
        largest = left;
    if (right < n && heap[right] > heap[largest])
        largest = right;
    if (largest != i) {
        int temp = heap[i];
        heap[i] = heap[largest];
        heap[largest] = temp;
        heapify(heap, n, largest);
    }
}
void buildHeap(int heap[], int n) {
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(heap, n, i);
}
int deleteMax(int heap[], int *n) {
    int max = heap[0];
    heap[0] = heap[*n - 1];
    (*n)--;
    heapify(heap, *n, 0);
    return max;
}
void insertHeap(int heap[], int *n, int value) {
    int i = *n;
    heap[i] = value;
    (*n)++;
    while (i > 0) {
        int parent = (i - 1) / 2;
        if (heap[parent] < heap[i]) {
            int temp = heap[parent];
            heap[parent] = heap[i];
            heap[i] = temp;
            i = parent;
        } else {
            break;
        }
    }
}
int main() {
    int n;
    printf("Enter number of rocks: ");
    scanf("%d", &n);
    int heap[10000];
    printf("Enter rock weights: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &heap[i]);
    buildHeap(heap, n);
    while (n > 1) {
        int first = deleteMax(heap, &n);
        int second = deleteMax(heap, &n);
        if (first != second) {
            insertHeap(heap, &n, first - second);
        }
    }
    if (n == 1)
        printf("Last remaining rock = %d\n", heap[0]);
    else
        printf("Last remaining rock = 0\n");
    return 0;
}