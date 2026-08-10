#include <stdlib.h>

typedef struct {
    int length;
    int beauty;
} Song;

void swap(Song *a, Song *b) {
    Song temp = *a;
    *a = *b;
    *b = temp;
}

void heapPush(long long *heap, int *size, long long value) {
    int i = (*size)++;
    heap[i] = value;

    while (i > 0) {
        int p = (i - 1) / 2;
        if (heap[p] <= heap[i])
            break;
        swap((Song *)&heap[p], (Song *)&heap[i]);
        i = p;
    }
}

long long heapPop(long long *heap, int *size) {
    long long result = heap[0];
    heap[0] = heap[--(*size)];

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

int compare(const void *a, const void *b) {
    Song *x = (Song *)a;
    Song *y = (Song *)b;
    return y->beauty - x->beauty;
}

long long maxPlaylistPleasure(int *length, int *beauty, int n, int k) {
    Song *songs = malloc(n * sizeof(Song));
    long long *heap = malloc(k * sizeof(long long));

    for (int i = 0; i < n; i++) {
        songs[i].length = length[i];
        songs[i].beauty = beauty[i];
    }

    qsort(songs, n, sizeof(Song), compare);

    long long sum = 0;
    long long ans = 0;
    int size = 0;

    for (int i = 0; i < n; i++) {
        sum += songs[i].length;
        heapPush(heap, &size, songs[i].length);

        if (size > k)
            sum -= heapPop(heap, &size);

        long long pleasure = sum * songs[i].beauty;
        if (pleasure > ans)
            ans = pleasure;
    }

    free(songs);
    free(heap);

    return ans;
}