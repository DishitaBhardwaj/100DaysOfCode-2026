#include <stdio.h>
#include <stdlib.h>

long long mergeAndCount(int* arr, int* temp, int left, int mid, int right) {
    int i = left;    
    int j = mid + 1;
    int k = left;     long long inv_count = 0;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
            inv_count += (mid - i + 1);
        }
    }

    while (i <= mid) {
        temp[k++] = arr[i++];
    }

    while (j <= right) {
        temp[k++] = arr[j++];
    }

    for (i = left; i <= right; i++) {
        arr[i] = temp[i];
    }

    return inv_count;
}

long long mergeSortAndCount(int* arr, int* temp, int left, int right) {
    long long inv_count = 0;
    if (left < right) {
        int mid = left + (right - left) / 2;

        inv_count += mergeSortAndCount(arr, temp, left, mid);
        inv_count += mergeSortAndCount(arr, temp, mid + 1, right);

        inv_count += mergeAndCount(arr, temp, left, mid, right);
    }
    return inv_count;
}

long long countInversions(int* arr, int arrSize) {
    int* temp = (int*)malloc(arrSize * sizeof(int));
    long long result = mergeSortAndCount(arr, temp, 0, arrSize - 1);
    free(temp);
    return result;
}

int main() {
    int arr[] = {2, 4, 1, 3, 5};
    int size = sizeof(arr) / sizeof(arr[0]);

    long long inversions = countInversions(arr, size);
    printf("Number of inversions: %lld (Expected: 3)\n", inversions);

    return 0;
}