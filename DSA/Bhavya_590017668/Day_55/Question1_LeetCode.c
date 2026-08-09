int* maxSubsequence(int* nums, int numsSize, int k, int* returnSize) {
    int* ans = (int*)malloc(k * sizeof(int));
    int* used = (int*)calloc(numsSize, sizeof(int));
    
    for (int i = 0; i < k; i++) {
        int maxIndex = -1;
        for (int j = 0; j < numsSize; j++) {
            if (!used[j] && (maxIndex == -1 || nums[j] > nums[maxIndex])) {
                maxIndex = j;
            }
        }
        used[maxIndex] = 1;
        ans[i] = maxIndex;
    }
    
    for (int i = 0; i < k; i++) {
        for (int j = i + 1; j < k; j++) {
            if (ans[i] > ans[j]) {
                int temp = ans[i];
                ans[i] = ans[j];
                ans[j] = temp;
            }
        }
    }
    
    for (int i = 0; i < k; i++)
        ans[i] = nums[ans[i]];
    
    free(used);
    *returnSize = k;
    return ans;
}