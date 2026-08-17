import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = log.length();
        int m = pattern.length();
        
        if (n < m) return result;
        
        int[] patternCount = new int[26];
        int[] windowCount = new int[26];
        
        // Initialize pattern frequency and first window frequency
        for (int i = 0; i < m; i++) {
            patternCount[pattern.charAt(i) - 'a']++;
            windowCount[log.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(patternCount, windowCount)) {
            result.add(0);
        }
        
        // Slide the window: add new char on right, remove leftmost char
        for (int i = m; i < n; i++) {
            windowCount[log.charAt(i) - 'a']++;              // add new char
            windowCount[log.charAt(i - m) - 'a']--;           // remove old char
            
            if (Arrays.equals(patternCount, windowCount)) {
                result.add(i - m + 1);
            }
        }
        
        return result;
    }
}
