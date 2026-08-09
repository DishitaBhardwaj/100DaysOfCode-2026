#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100000

int* maxSlidingWindow(int temperatures[], int n, int k, int* resultSize) {
    int* result = (int*)malloc((n - k + 1) * sizeof(int));
    int deque[MAX_SIZE];

    int front = 0;
    int back = 0;
    int index = 0;

    for (int i = 0; i < n; i++) {

        while (front < back && deque[front] <= i - k) {
            front++;
        }

        while (front < back &&
               temperatures[deque[back - 1]] <= temperatures[i]) {
            back--;
        }

        deque[back++] = i;

        if (i >= k - 1) {
            result[index++] = temperatures[deque[front]];
        }
    }

    *resultSize = n - k + 1;

    return result;
}

int main() {
    int n, k;

    printf("Enter number of temperatures: ");
    scanf("%d", &n);

    int temperatures[n];

    printf("Enter temperatures:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &temperatures[i]);
    }

    printf("Enter window size k: ");
    scanf("%d", &k);

    int resultSize;

    int* result = maxSlidingWindow(
        temperatures,
        n,
        k,
        &resultSize
    );

    printf("Maximum temperature in each window: ");

    for (int i = 0; i < resultSize; i++) {
        printf("%d ", result[i]);
    }

    printf("\n");

    free(result);

    return 0;
}