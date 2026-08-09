import java.util.Scanner;
import java.util.Stack;

class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String postfix = sc.nextLine();

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String prefix = ch + op1 + op2;
                stack.push(prefix);
            }
        }

        System.out.println("Prefix Expression: " + stack.pop());
    }
}