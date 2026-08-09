package DSA.TanmaySharma_590011578.Day_52;
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int target = 0;

        // Check if all non-zero frequencies are equal
        for (int count : freq) {
            if (count == 0) continue;

            if (target == 0) {
                target = count;
            } else if (count != target) {
                return false;
            }
        }

        return true;
    }
}