#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int arrayPairSum(int* nums, int numsSize) {
    qsort(nums, numsSize, sizeof(int), compare);

    int sum = 0;

    for (int i = 0; i < numsSize; i += 2) {
        sum += nums[i];
    }

    return sum;
}

int main() {
    int n;

    printf("Enter n: ");
    scanf("%d", &n);

    int size = 2 * n;
    int* nums = (int*)malloc(size * sizeof(int));

    printf("Enter %d elements:\n", size);

    for (int i = 0; i < size; i++) {
        scanf("%d", &nums[i]);
    }

    int result = arrayPairSum(nums, size);

    printf("Maximum sum of pair minimums: %d\n", result);

    free(nums);

    return 0;
}