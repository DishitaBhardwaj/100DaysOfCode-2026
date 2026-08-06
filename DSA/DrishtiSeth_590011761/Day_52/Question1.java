import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int frequency = -1;

        for (int value : map.values()) {
            if (frequency == -1) {
                frequency = value;
            } else if (value != frequency) {
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
