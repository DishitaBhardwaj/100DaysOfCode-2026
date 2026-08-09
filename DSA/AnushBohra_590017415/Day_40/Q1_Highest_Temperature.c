#include <stdio.h>
#include <stdlib.h>

int* maxSlidingWindow(int* nums, int numsSize, int k, int* returnSize) {
    if (numsSize == 0 || k == 0) {
        *returnSize = 0;
        return NULL;
    }

    *returnSize = numsSize - k + 1;
    int* result = (int*)malloc((*returnSize) * sizeof(int));
    
    int* deque = (int*)malloc(numsSize * sizeof(int));
    int head = 0;
    int tail = 0;

    int resultIndex = 0;

    for (int i = 0; i < numsSize; i++) {
        if (head < tail && deque[head] <= i - k) {
            head++;
        }

        while (head < tail && nums[deque[tail - 1]] <= nums[i]) {
            tail--;
        }

        deque[tail++] = i;

        if (i >= k - 1) {
            result[resultIndex++] = nums[deque[head]];
        }
    }

    free(deque);
    return result;
}

int main() {
    int temperatures[] = {1, 3, -1, -3, 5, 3, 6, 7};
    int size = sizeof(temperatures) / sizeof(temperatures[0]);
    int k = 3;
    int returnSize = 0;

    int* result = maxSlidingWindow(temperatures, size, k, &returnSize);

    printf("Output: [");
    for (int i = 0; i < returnSize; i++) {
        printf("%d%s", result[i], (i == returnSize - 1) ? "" : ", ");
    }
    printf("]\n");

    free(result);
    return 0;
}