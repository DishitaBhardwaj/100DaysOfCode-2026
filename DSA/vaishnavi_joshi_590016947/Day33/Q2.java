import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If operand, push into stack
            if (Character.isLetter(ch)) {
                stack.push(String.valueOf(ch));
            }

            // If operator
            else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                String expression = ch + operand1 + operand2;

                stack.push(expression);
            }
        }

        System.out.println(stack.pop());
    }
}