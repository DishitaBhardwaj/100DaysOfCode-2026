int mostFrequentEven(int* nums, int numsSize) {
    int freq[100001]={0};
    
    for(int i=0;i<numsSize;i++){
        if (nums[i]%2==0){
            freq[nums[i]]++;
        }
    }
    int maxFreq=0;
    int result=-1;
    
    for (int i=0;i<=100000;i++){
        if (freq[i]>maxFreq){
            maxFreq=freq[i];
            result=i;
        }
    }

    return result;
}
