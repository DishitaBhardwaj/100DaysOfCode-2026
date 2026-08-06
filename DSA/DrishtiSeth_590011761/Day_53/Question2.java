import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String log, String pattern) {

        List<Integer> ans = new ArrayList<>();

        if (pattern.length() > log.length()) {
            return ans;
        }

        int[] pat = new int[26];
        int[] window = new int[26];

        for (char c : pattern.toCharArray()) {
            pat[c - 'a']++;
        }

        int k = pattern.length();

        for (int i = 0; i < k; i++) {
            window[log.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pat, window)) {
            ans.add(0);
        }

        for (int i = k; i < log.length(); i++) {

            window[log.charAt(i) - 'a']++;
            window[log.charAt(i - k) - 'a']--;

            if (Arrays.equals(pat, window)) {
                ans.add(i - k + 1);
            }
        }

        return ans;
    }
}
