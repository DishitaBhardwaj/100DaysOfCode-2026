import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> result = new ArrayList<>();

        if (log.length() < pattern.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] wCount = new int[26];

        // Frequency of pattern
        for (char ch : pattern.toCharArray()) {
            pCount[ch - 'a']++;
        }

        int k = pattern.length();

        // First window
        for (int i = 0; i < k; i++) {
            wCount[log.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, wCount)) {
            result.add(0);
        }

        // Sliding Window
        for (int i = k; i < log.length(); i++) {
            wCount[log.charAt(i - k) - 'a']--; // Remove left character
            wCount[log.charAt(i) - 'a']++;     // Add right character

            if (Arrays.equals(pCount, wCount)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}