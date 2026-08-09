#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int compare(const void* a, const void* b) {
    return (*(int*)a > *(int*)b) - (*(int*)a < *(int*)b);
}

bool canMakeArithmeticProgression(int arr[], int n) {
    qsort(arr, n, sizeof(int), compare);

    int difference = arr[1] - arr[0];

    for (int i = 2; i < n; i++) {
        if (arr[i] - arr[i - 1] != difference) {
            return false;
        }
    }

    return true;
}

int main() {
    int n;

    printf("Enter array size: ");
    scanf("%d", &n);

    int* arr = (int*)malloc(n * sizeof(int));

    printf("Enter array elements:\n");

    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    if (canMakeArithmeticProgression(arr, n)) {
        printf("true\n");
    } else {
        printf("false\n");
    }

    free(arr);

    return 0;
}