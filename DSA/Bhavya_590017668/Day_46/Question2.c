#include <stdio.h>

void maximizePrefixDifference(int arr[], int n) {
    if (n <= 1) return;

    int minIdx = 0, maxIdx = 0;

    for (int i = 1; i < n; i++) {
        if (arr[i] < arr[minIdx])
            minIdx = i;
        if (arr[i] > arr[maxIdx])
            maxIdx = i;
    }

    int temp = arr[0];
    arr[0] = arr[minIdx];
    arr[minIdx] = temp;

    if (maxIdx == 0)
        maxIdx = minIdx;

    temp = arr[1];
    arr[1] = arr[maxIdx];
    arr[maxIdx] = temp;
}