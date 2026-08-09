import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) {
                    result.append(ch);
                }
                depth++;
            } else {
                depth--;
                if (depth > 0) {
                    result.append(ch);
                }
            }
        }

        System.out.println(result.toString());
    }
}