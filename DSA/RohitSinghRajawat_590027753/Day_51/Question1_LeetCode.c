int compare(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

int mostFrequentEven(int* nums, int numsSize)
{
    qsort(nums, numsSize, sizeof(int), compare);

    int ans = -1;
    int maxFreq = 0;

    for(int i = 0; i < numsSize;)
    {
        int count = 1;

        while(i + count < numsSize && nums[i] == nums[i + count])
        {
            count++;
        }

        if(nums[i] % 2 == 0 && count > maxFreq)
        {
            maxFreq = count;
            ans = nums[i];
        }

        i += count;
    }

    return ans;
}