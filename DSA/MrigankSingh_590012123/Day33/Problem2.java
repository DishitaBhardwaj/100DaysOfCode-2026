import java.util.Stack;

public class Problem2 {
    public String postfixToPrefix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (Character.isLetterOrDigit(current)) {
                stack.push(String.valueOf(current));
            } else {
                String second = stack.pop();
                String first = stack.pop();
                stack.push(current + first + second);
            }
        }

        return stack.pop();
    }
}