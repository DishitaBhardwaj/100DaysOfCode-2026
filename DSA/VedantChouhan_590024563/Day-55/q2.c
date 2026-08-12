#include <stdio.h>
#include <stdlib.h>

typedef struct {
    long long length;
    long long beauty;
} Song;

int compare(const void *a, const void *b) {
    Song *x = (Song *)a;
    Song *y = (Song *)b;

    if (x->beauty < y->beauty)
        return 1;
    if (x->beauty > y->beauty)
        return -1;

    return 0;
}

/* Insert into min-heap */
void push(long long heap[], int *size, long long value) {

    int i = *size;
    heap[i] = value;
    (*size)++;

    while (i > 0) {

        int parent = (i - 1) / 2;

        if (heap[parent] <= heap[i])
            break;

        long long temp = heap[parent];
        heap[parent] = heap[i];
        heap[i] = temp;

        i = parent;
    }
}

/* Remove minimum from min-heap */
long long pop(long long heap[], int *size) {

    long long result = heap[0];

    (*size)--;

    heap[0] = heap[*size];

    int i = 0;

    while (1) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < *size && heap[left] < heap[smallest])
            smallest = left;

        if (right < *size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest == i)
            break;

        long long temp = heap[i];
        heap[i] = heap[smallest];
        heap[smallest] = temp;

        i = smallest;
    }

    return result;
}

int main() {

    int n, k;

    printf("Enter number of songs: ");
    scanf("%d", &n);

    long long length[n];
    long long beauty[n];

    printf("Enter lengths: ");
    for (int i = 0; i < n; i++)
        scanf("%lld", &length[i]);

    printf("Enter beauty values: ");
    for (int i = 0; i < n; i++)
        scanf("%lld", &beauty[i]);

    printf("Enter k: ");
    scanf("%d", &k);

    Song songs[n];

    for (int i = 0; i < n; i++) {
        songs[i].length = length[i];
        songs[i].beauty = beauty[i];
    }

    qsort(songs, n, sizeof(Song), compare);

    long long heap[k];
    int heapSize = 0;

    long long sum = 0;
    long long maxPleasure = 0;

    for (int i = 0; i < n; i++) {

        push(heap, &heapSize, songs[i].length);
        sum += songs[i].length;

        if (heapSize > k) {
            sum -= pop(heap, &heapSize);
        }
        long long pleasure = sum * songs[i].beauty;

        if (pleasure > maxPleasure)
            maxPleasure = pleasure;
    }

    printf("Maximum Pleasure: %lld\n", maxPleasure);

    return 0;
}