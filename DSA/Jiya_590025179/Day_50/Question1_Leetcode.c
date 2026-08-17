/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getFinalState(int* nums, int numsSize, int k, int multiplier, int* returnSize) {
    *returnSize=numsSize;
    while (k--){
        int min=0;
        for(int i=1;i<numsSize;i++) if(nums[i]<nums[min]) min=i;
        nums[min]=nums[min]*multiplier;
    }

    return nums;
}
