/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getFinalState(int* nums, int numsSize, int k, int multiplier, int* returnSize)
{
    while(k--)
    {
        int minIndex = 0;

        for(int i = 1; i < numsSize; i++)
        {
            if(nums[i] < nums[minIndex])
            {
                minIndex = i;
            }
        }

        nums[minIndex] *= multiplier;
    }

    *returnSize = numsSize;
    return nums;
}