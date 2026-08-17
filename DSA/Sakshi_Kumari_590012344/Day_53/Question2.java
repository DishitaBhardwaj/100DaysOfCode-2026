import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> res = new ArrayList<>();

        if (log.length() < pattern.length()) {
            return res;
        }

        int[] p = new int[26];
        int[] w = new int[26];

        for (int i = 0; i < pattern.length(); i++) {
            p[pattern.charAt(i) - 'a']++;
        }

        int k = pattern.length();

        for (int i = 0; i < log.length(); i++) {
            w[log.charAt(i) - 'a']++;

            if (i >= k) {
                w[log.charAt(i - k) - 'a']--;
            }

            if (i >= k - 1 && Arrays.equals(p, w)) {
                res.add(i - k + 1);
            }
        }

        return res;
    }
}
