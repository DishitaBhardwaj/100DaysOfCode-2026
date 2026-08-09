package DSA.Mugdha_590015431.Day_33;
import java.util.*;

public class Question1_LeetCode {

    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                if (depth > 0) {
                    ans.append(ch);
                }
                depth++;
            } else {
                depth--;

                if (depth > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(removeOuterParentheses(s));

        sc.close();
    }
}