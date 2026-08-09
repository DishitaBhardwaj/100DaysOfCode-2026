class Solution {
    public int maxFrequencyElements(int[] nums) {
         int[] freq = new int[101];

        // Count frequency of each element
        for (int num : nums) {
            freq[num]++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Add frequencies of all elements having max frequency
        int result = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                result += f;
            }
        }

        return result;
        
    }
}
