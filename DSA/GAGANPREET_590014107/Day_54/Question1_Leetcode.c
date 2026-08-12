int maxFrequencyElements(int* nums, int numsSize) {
    int freq[101] = {0};

    for (int i=0; i<numsSize; i++ ) {
        freq[nums[i]]++;
    }
    int maxFreq=0;
    for (int i=0; i<100; i++) {
        if (freq[i]> maxFreq)
          maxFreq= freq[i];
    }    

    int ans = 0;
    for (int i=0; i<=100; i++) {
        if (freq[i] == maxFreq)
         ans += freq[i];

    }
    return ans;
}
