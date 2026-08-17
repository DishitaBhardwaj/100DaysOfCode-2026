int maxFrequencyElements(int* nums, int numsSize) {
    int freq[101] = {0};
    int maxFreq = 0;
    int total = 0;

    for (int i = 0; i < numsSize; i++) {
        freq[nums[i]]++;
        if (freq[nums[i]] > maxFreq)
            maxFreq = freq[nums[i]];
    }

    for (int i = 0; i < 101; i++) {
        if (freq[i] == maxFreq)
            total += freq[i];
    }

    return total;
}