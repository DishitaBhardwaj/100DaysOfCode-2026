#include <stdio.h>

long long maximizePrefixDifference(const int arr[], int n) {
    if (n <= 1) {
        return 0;
    }

    int min_val = arr[0];
    int max_val = arr[0];

    for (int i = 1; i < n; i++) {
        if (arr[i] < min_val) {
            min_val = arr[i];
        }
        if (arr[i] > max_val) {
            max_val = arr[i];
        }
    }

    long long max_diff = (long long)max_val - min_val;
    long long max_score = (n - 1) * max_diff;

    return max_score;
}

int main(void) {
    int arr[] = {7, 6, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    long long result = maximizePrefixDifference(arr, n);
    printf("Max Score: %lld\n", result); // Output: 4

    return 0;
}