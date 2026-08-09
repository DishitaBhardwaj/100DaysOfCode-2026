package Day_52;

import java.util.*;

public class d52question1_leetcode {
    public static boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        int expected = -1;
        for (int count : freq.values()) {
            if (expected == -1) expected = count;
            else if (count != expected) return false;
        }
        
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String s = sc.nextLine();
            System.out.println(areOccurrencesEqual(s));
        sc.close();    }}
