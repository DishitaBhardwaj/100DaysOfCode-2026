#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int arrayPairSum(int nums[], int size) {
    qsort(nums, size, sizeof(int), compare);

    int sum = 0;
    for (int i = 0; i < size; i += 2) {
        sum += nums[i];
    }

    return sum;
}

int main() {
    int n;
    scanf("%d", &n);

    int nums[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    printf("%d\n", arrayPairSum(nums, n));

    return 0;
}