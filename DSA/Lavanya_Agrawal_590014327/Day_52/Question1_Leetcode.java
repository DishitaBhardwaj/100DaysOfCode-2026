import java.util.*;

public class Question1_Leetcode {

    public static boolean areOccurrencesEqual(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int frequency = -1;

        for (int count : map.values()) {
            if (frequency == -1) {
                frequency = count;
            } else if (count != frequency) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(areOccurrencesEqual(s));

        sc.close();
    }
}