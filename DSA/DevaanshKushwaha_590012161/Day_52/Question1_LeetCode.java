class Solution {
    public boolean areOccurrencesEqual(String s) {
        // Step 1: Count frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Step 2: Find the frequency of the first character that appears
        int target = -1;
        
        // Step 3: Compare all non-zero frequencies against target
        for (int f : freq) {
            if (f == 0) continue; // character not present, skip
            if (target == -1) {
                target = f; // set baseline frequency
            } else if (f != target) {
                return false; // mismatch found
            }
        }
        
        return true;
    }
}
