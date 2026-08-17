#include <stdio.h>
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getFinalState(int* nums, int numsSize, int k, int multiplier, int* returnSize) {
    int* result = (int*)malloc(numsSize * sizeof(int));
    if (result == NULL) {
        *returnSize = 0;
        return NULL;
    }

    for (int i = 0; i < numsSize; i++) {
        result[i] = nums[i];
    }

    for (int op = 0; op < k; op++) {
        int min_idx = 0;
        for (int i = 1; i < numsSize; i++) {
            if (result[i] < result[min_idx]) {
                min_idx = i;
            }
        }
        result[min_idx] *= multiplier;
    }

    *returnSize = numsSize;
    return result;
}

int main(void) {
    // Example test case
    int nums[] = {2, 1, 3, 5, 6};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int k = 5;
    int multiplier = 2;
    int returnSize = 0;

    int* finalState = getFinalState(nums, numsSize, k, multiplier, &returnSize);

    printf("Final Array State: [");
    for (int i = 0; i < returnSize; i++) {
        printf("%d%s", finalState[i], (i == returnSize - 1) ? "" : ", ");
    }
    printf("]\n");

    // Clean up dynamically allocated memory
    free(finalState);

    return 0;
}