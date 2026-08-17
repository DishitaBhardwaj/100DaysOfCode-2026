int* getFinalState(int* nums, int numsSize, int k, int multiplier, int* returnSize) {
    *returnSize = numsSize;
    for (int i = 0; i < k; i++) {
        int minIndex = 0;
        for (int j = 1; j < numsSize; j++) {
            if (nums[j] < nums[minIndex]) {
                minIndex = j;
            }
        }

        nums[minIndex] = nums[minIndex] * multiplier;
    }
    return nums;

}