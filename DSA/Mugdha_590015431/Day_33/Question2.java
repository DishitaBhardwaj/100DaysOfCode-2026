package DSA.Mugdha_590015431.Day_33;
import java.util.*;

public class Question2 {

    public static String postfixToPrefix(String exp) {
        Stack<String> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String temp = ch + op1 + op2;

                stack.push(temp);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String exp = sc.next();

        System.out.println(postfixToPrefix(exp));

        sc.close();
    }
}