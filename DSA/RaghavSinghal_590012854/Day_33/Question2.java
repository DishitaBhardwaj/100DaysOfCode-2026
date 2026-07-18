import java.util.Stack;

class Solution {
    public String postToPre(String s) {
        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                stack.push(ch + op1 + op2);
            }
        }

        return stack.pop();
    }
}