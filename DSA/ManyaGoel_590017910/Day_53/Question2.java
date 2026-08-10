import java.util.*;

public class Question2 {
    public static List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> ans = new ArrayList<>();

        int n = log.length();
        int m = pattern.length();

        if (m > n) {
            return ans;
        }

        int[] patFreq = new int[26];
        int[] winFreq = new int[26];

        for (int i = 0; i < m; i++) {
            patFreq[pattern.charAt(i) - 'a']++;
            winFreq[log.charAt(i) - 'a']++;
        }
        if (Arrays.equals(patFreq, winFreq)) {
            ans.add(0);
        }
        for (int r = m; r < n; r++) {
            winFreq[log.charAt(r) - 'a']++;
            int l = r - m;
            winFreq[log.charAt(l) - 'a']--;
            if (Arrays.equals(patFreq, winFreq)) {
                ans.add(l + 1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter log: ");
        String log = sc.nextLine().trim();

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine().trim();
        
        System.out.println("Log: \"" + log + "\"");
        System.out.println("Pattern: \"" + pattern + "\"");

        List<Integer> ans = findAnagrams(log, pattern);
        System.out.println("Starting indices: " + ans);
        sc.close();
    }
}