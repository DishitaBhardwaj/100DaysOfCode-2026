#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int maximumPrefixDifferenceScore(int arr[], int n) {
    qsort(arr, n, sizeof(int), cmp);

    int max = arr[n - 1];
    int min = arr[0];

    int score = 0;

    // First prefix contributes 0.
    for (int i = 2; i <= n; i++)
        score += (max - min);

    return score;
}

int main() {
    int arr[] = {7, 6, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("%d\n", maximumPrefixDifferenceScore(arr, n));

    return 0;
}
