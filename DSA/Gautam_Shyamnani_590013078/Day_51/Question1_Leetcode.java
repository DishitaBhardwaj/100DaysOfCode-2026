class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] freq = new int[100001];
        for(int num : nums){
            if(num % 2 == 0){
                freq[num]++;
            }
        }
        int maxOccur = 0;
        int result = -1;

        for(int i = 0; i < 100001; i += 2){
            if(freq[i] > maxOccur){
                maxOccur = freq[i];
                result = i;
            }
        }
        return result;
    }
}