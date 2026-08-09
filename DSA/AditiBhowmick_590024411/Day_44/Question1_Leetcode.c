#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

bool canMakeArithmeticProgression(int arr[], int n) {
    qsort(arr, n, sizeof(int), compare);

    int diff = arr[1] - arr[0];

    for (int i = 2; i < n; i++) {
        if (arr[i] - arr[i - 1] != diff)
            return false;
    }
    return true;
}

int main() {
    int n;

    printf("Enter the number of elements: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter the elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    if (canMakeArithmeticProgression(arr, n))
        printf("true\n");
    else
        printf("false\n");
    return 0;
}