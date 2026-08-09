int* getFinalState(int* nums, int numsSize, int k, int multiplier, int* returnSize) {
    *returnSize = numsSize;

    while (k--) {
        int minIndex = 0;

        for (int i = 1; i < numsSize; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }

        nums[minIndex] *= multiplier;
    }

    return nums;
}