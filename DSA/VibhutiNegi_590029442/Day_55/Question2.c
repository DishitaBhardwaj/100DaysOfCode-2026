#include <stdio.h>
#include <stdlib.h>
typedef struct {
    int length;
    int beauty;
} Song;
int compare(const void *a, const void *b) {
    Song *x = (Song *)a;
    Song *y = (Song *)b;
    return y->beauty - x->beauty;
}
long long maxPleasure(int *length, int *beauty, int n, int k) {
    Song *songs = malloc(n * sizeof(Song));
    for (int i = 0; i < n; i++) {
        songs[i].length = length[i];
        songs[i].beauty = beauty[i];
    }
    qsort(songs, n, sizeof(Song), compare);
    int *heap = malloc(k * sizeof(int));
    int heapSize = 0;
    long long sum = 0;
    long long answer = 0;
    for (int i = 0; i < n; i++) {
        int pos = heapSize;
        heap[heapSize++] = songs[i].length;
        sum += songs[i].length;
        while (pos > 0) {
            int parent = (pos - 1) / 2;
            if (heap[parent] <= heap[pos])
                break;
            int temp = heap[parent];
            heap[parent] = heap[pos];
            heap[pos] = temp;
            pos = parent;
        }
        if (heapSize > k) {
            sum -= heap[0];
            heap[0] = heap[heapSize - 1];
            heapSize--;
            pos = 0;
            while (1) {
                int left = 2 * pos + 1;
                int right = 2 * pos + 2;
                int smallest = pos;
                if (left < heapSize && heap[left] < heap[smallest])
                    smallest = left;
                if (right < heapSize && heap[right] < heap[smallest])
                    smallest = right;
                if (smallest == pos)
                    break;
                int temp = heap[pos];
                heap[pos] = heap[smallest];
                heap[smallest] = temp;
                pos = smallest;
            }
        }
        long long pleasure = sum * songs[i].beauty;
        if (pleasure > answer)
            answer = pleasure;
    }
    free(songs);
    free(heap);
    return answer;
}
int main() {
    int n, k;
    printf("Enter number of songs: ");
    scanf("%d", &n);
    int *length = malloc(n * sizeof(int));
    int *beauty = malloc(n * sizeof(int));
    printf("Enter lengths: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &length[i]);
    }
    printf("Enter beauty values: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &beauty[i]);
    }
    printf("Enter k: ");
    scanf("%d", &k);
    long long answer = maxPleasure(length, beauty, n, k);
    printf("Maximum Pleasure = %lld\n", answer);
    free(length);
    free(beauty);
    return 0;
}