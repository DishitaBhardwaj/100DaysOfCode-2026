package DSA.TanmaySharma_590011578.Day_53;

import java.util.*;

public class Question2 {

    public static List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> result = new ArrayList<>();

        if (log.length() < pattern.length()) {
            return result;
        }

        int[] patternCount = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < pattern.length(); i++) {
            patternCount[pattern.charAt(i) - 'a']++;
            windowCount[log.charAt(i) - 'a']++;
        }

        if (Arrays.equals(patternCount, windowCount)) {
            result.add(0);
        }

        for (int i = pattern.length(); i < log.length(); i++) {
            windowCount[log.charAt(i) - 'a']++;
            windowCount[log.charAt(i - pattern.length()) - 'a']--;

            if (Arrays.equals(patternCount, windowCount)) {
                result.add(i - pattern.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String log = sc.nextLine();
        String pattern = sc.nextLine();

        List<Integer> ans = findAnagrams(log, pattern);

        System.out.println(ans);
    }
}
