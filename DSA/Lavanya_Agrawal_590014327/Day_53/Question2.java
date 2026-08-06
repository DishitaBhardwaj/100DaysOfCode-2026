import java.util.*;

public class Question2 {

    public static List<Integer> findAnagrams(String log, String pattern) {

        List<Integer> result = new ArrayList<>();

        if (pattern.length() > log.length()) {
            return result;
        }

        int[] patternFreq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < pattern.length(); i++) {
            patternFreq[pattern.charAt(i) - 'a']++;
            windowFreq[log.charAt(i) - 'a']++;
        }

        if (Arrays.equals(patternFreq, windowFreq)) {
            result.add(0);
        }

        for (int i = pattern.length(); i < log.length(); i++) {
            windowFreq[log.charAt(i) - 'a']++;
            windowFreq[log.charAt(i - pattern.length()) - 'a']--;

            if (Arrays.equals(patternFreq, windowFreq)) {
                result.add(i - pattern.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String log = sc.next();
        String pattern = sc.next();

        List<Integer> ans = findAnagrams(log, pattern);

        System.out.println(ans);

        sc.close();
    }
}