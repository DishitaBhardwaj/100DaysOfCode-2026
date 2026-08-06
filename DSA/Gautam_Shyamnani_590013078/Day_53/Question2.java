import java.util.*;

public class Question2 {

    public static List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> result = new ArrayList<>();

        int n = log.length();
        int k = pattern.length();

        if (n < k) return result;

        int[] freq = new int[26];

        for (char c : pattern.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            freq[log.charAt(i) - 'a']--;

            if (i >= k) {
                freq[log.charAt(i - k) - 'a']++;
            }

            boolean isAnagram = true;
            for (int j = 0; j < 26; j++) {
                if (freq[j] != 0) {
                    isAnagram = false;
                    break;
                }
            }

            if (isAnagram) {
                result.add(i - k + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String log = "cbaebabacd";
        String pattern = "abc";

        System.out.println(findAnagrams(log, pattern));
    }
}