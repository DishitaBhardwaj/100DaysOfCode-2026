import java.util.*;

public class Main {

    public static List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> ans = new ArrayList<>();

        if (log.length() < pattern.length()) {
            return ans;
        }

        int[] pCount = new int[26];
        int[] wCount = new int[26];

        for (int i = 0; i < pattern.length(); i++) {
            pCount[pattern.charAt(i) - 'a']++;
            wCount[log.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, wCount)) {
            ans.add(0);
        }

        for (int i = pattern.length(); i < log.length(); i++) {
            wCount[log.charAt(i) - 'a']++;
            wCount[log.charAt(i - pattern.length()) - 'a']--;

            if (Arrays.equals(pCount, wCount)) {
                ans.add(i - pattern.length() + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String log = "cbaebabacd";
        String pattern = "abc";

        System.out.println(findAnagrams(log, pattern));
    }
}
