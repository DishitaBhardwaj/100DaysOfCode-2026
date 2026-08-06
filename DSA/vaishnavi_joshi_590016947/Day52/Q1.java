class Solution {
    public boolean areOccurrencesEqual(String s) {

        int[] freq = new int[26];

        // Count frequency of every character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find frequency of first character
        int expected = 0;

        for (int count : freq) {
            if (count > 0) {
                expected = count;
                break;
            }
        }

        // Check all occurring characters
        for (int count : freq) {
            if (count > 0 && count != expected) {
                return false;
            }
        }

        return true;
    }
}class Solution {
    public boolean areOccurrencesEqual(String s) {

        int[] freq = new int[26];

        // Count frequency of every character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find frequency of first character
        int expected = 0;

        for (int count : freq) {
            if (count > 0) {
                expected = count;
                break;
            }
        }

        // Check all occurring characters
        for (int count : freq) {
            if (count > 0 && count != expected) {
                return false;
            }
        }

        return true;
    }
}