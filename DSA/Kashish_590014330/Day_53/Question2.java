import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> ans = new ArrayList<>();

        if (log.length() < pattern.length())
            return ans;

        int[] p = new int[26];
        int[] w = new int[26];
        for (int i = 0; i < pattern.length(); i++) {
            p[pattern.charAt(i) - 'a']++;
            w[log.charAt(i) - 'a']++;
        }
        if (Arrays.equals(p, w))
            ans.add(0);
        for (int i = pattern.length(); i < log.length(); i++) {
            w[log.charAt(i) - 'a']++;                     
            w[log.charAt(i - pattern.length()) - 'a']--;  

            if (Arrays.equals(p, w))
                ans.add(i - pattern.length() + 1);
        }

        return ans;
    }
}