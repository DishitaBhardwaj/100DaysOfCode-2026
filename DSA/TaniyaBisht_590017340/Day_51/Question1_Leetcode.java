
class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int ans = -1;
        int maxFreq = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] % 2 != 0)
                continue;
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            int freq = freqMap.get(nums[i]);
            if(freq > maxFreq){
                maxFreq = freq;
                ans = nums[i];
            }
            else if(freq == maxFreq && nums[i] < ans){
                ans = nums[i];
            }
        }
        return ans;
    }
}