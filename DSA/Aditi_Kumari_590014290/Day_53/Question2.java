package Day_53;
import java.util.*;
public class Question2 {
    public List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> ans = new ArrayList<>();
        if (log.length() < pattern.length()) {
            return ans;
        }
        int[] pFreq = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < pattern.length(); i++) {
            pFreq[pattern.charAt(i) - 'a']++;
            window[log.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pFreq, window)) {
            ans.add(0);
        }
        for (int i = pattern.length(); i < log.length(); i++) {
            window[log.charAt(i) - 'a']++;
            window[log.charAt(i - pattern.length()) - 'a']--;
            if (Arrays.equals(pFreq, window)) {
                ans.add(i - pattern.length() + 1);
            }
        }
        return ans;
    }
}
