
import java.util.Stack;

class Solution {

    public String removeOuterParentheses(String s) {

        // Stack to track parentheses
        Stack<Character> stack = new Stack<>();

        // Store answer
        StringBuilder answer = new StringBuilder();

        // Traverse string
        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // Add only if not outermost
                if (!stack.isEmpty()) {
                    answer.append(ch);
                }

                stack.push(ch);
            } else {

                // Remove matching '('
                stack.pop();

                // Add only if not outermost
                if (!stack.isEmpty()) {
                    answer.append(ch);
                }
            }
        }

        return answer.toString();
    }
}
