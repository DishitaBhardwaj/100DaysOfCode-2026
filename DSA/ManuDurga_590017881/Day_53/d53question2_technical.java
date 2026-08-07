package Day_53;

import java.util.*;

public class d53question2_technical {
    public static List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> ans = new ArrayList<>();
        int n = log.length(), m = pattern.length();
        if (n < m) return ans;

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : pattern.toCharArray()) need[c - 'a']++;

        for (int i = 0; i < n; i++) {
            window[log.charAt(i) - 'a']++;

            if (i >= m) {
                window[log.charAt(i - m) - 'a']--; // slide window
            }

            if (Arrays.equals(need, window)) {
                ans.add(i - m + 1);
            }
        }
        return ans;
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Log: ");
        String l = sc.nextLine();
        System.out.print("Enter Pattern: ");
        String patt = sc.nextLine();
        System.out.println(findAnagrams(l,patt));
        sc.close();}}
