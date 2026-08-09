class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        // Count frequency of each element
        for (int num : nums) {
            freq[num]++;
        }

        int maxFreq = 0;

        // Find the maximum frequency
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int ans = 0;

        // Sum all frequencies equal to maximum frequency
        for (int f : freq) {
            if (f == maxFreq) {
                ans += f;
            }
        }

        return ans;
    }
}