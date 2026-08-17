import java.util.HashMap;
import java.util.Map;

public class Question1_LeetCode {
    // HashMap Solution
    public static boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        int a = 0;
        for (int count : freqMap.values()) {
            if (a == 0) {
                a = count;
            }
            else if (a != count) {
                return false;
            }
        }
        return true;
    }

    // Optimized Solution
    public static boolean areOccurrencesEqualOptimized(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int a = 0;
        for (int count : freq) {
            if (count == 0) {
                continue;
            }
            if (a == 0) {
                a = count;
            } 
            else if (a != count) {
                return false;
            }
        }
        return true;
    }
}
