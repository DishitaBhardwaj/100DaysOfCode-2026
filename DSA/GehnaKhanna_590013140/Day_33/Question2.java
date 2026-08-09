import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String postfix = sc.nextLine();
        Stack<String> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {

            if (Character.isLetter(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String prefix = ch + op1 + op2;
                stack.push(prefix);
            }
        }

        System.out.println(stack.pop());

        sc.close();
    }
}
