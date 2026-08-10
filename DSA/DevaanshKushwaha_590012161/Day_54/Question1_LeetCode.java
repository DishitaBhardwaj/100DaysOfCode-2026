class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Step 1: Count frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Find the maximum frequency
        int maxFreq = 0;
        for (int freq : freqMap.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        
        // Step 3: Sum frequencies of elements that have maxFreq
        int totalCount = 0;
        for (int freq : freqMap.values()) {
            if (freq == maxFreq) {
                totalCount += freq;
            }
        }
        
        return totalCount;
    }
}
