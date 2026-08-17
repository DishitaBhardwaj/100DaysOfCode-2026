import java.util.*;

public class Main {

    public static List<Integer> findAnagrams(String log, String pattern) {

        List<Integer> result = new ArrayList<>();

        if (pattern.length() > log.length())
            return result;

        int[] pFreq = new int[26];
        int[] wFreq = new int[26];

        // Frequency of pattern
        for (char ch : pattern.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        int m = pattern.length();

        // First window
        for (int i = 0; i < m; i++) {
            wFreq[log.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, wFreq)) {
            result.add(0);
        }

        // Slide the window
        for (int i = m; i < log.length(); i++) {

            wFreq[log.charAt(i - m) - 'a']--;
            wFreq[log.charAt(i) - 'a']++;

            if (Arrays.equals(pFreq, wFreq)) {
                result.add(i - m + 1);
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
