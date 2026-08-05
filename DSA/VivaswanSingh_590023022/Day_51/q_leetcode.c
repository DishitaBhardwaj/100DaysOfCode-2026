int mostFrequentEven(int* nums, int numsSize)
{
    int freq[100001] = {0};

    for (int i = 0; i < numsSize; i++)
    {
        if (nums[i] % 2 == 0)
            freq[nums[i]]++;
    }

    int ans = -1;
    int maxFreq = 0;

    for (int i = 0; i <= 100000; i += 2)
    {
        if (freq[i] > maxFreq)
        {
            maxFreq = freq[i];
            ans = i;
        }
    }

    return ans;
}