import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Question2 {
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static String conversion(String s) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isOperator(ch)) {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String temp = ch + op1 + op2;

                stack.push(temp);
            } 
            else {
                stack.push(String.valueOf(ch));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a valid postfix expression: ");
        if (sc.hasNextLine()) {
            String post = sc.nextLine();
            try {
                String result = conversion(post);
                System.out.println("Prefix:  " + result);
            } 
            catch (Exception e) {
                System.out.println("Invalid postfix expression");
            }
        }
        sc.close();
    }
}