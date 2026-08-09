import java.util.Stack;

class Solution {

    public String postToPre(String s) {

        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Operand
            if (Character.isLetter(ch)) {
                stack.push(String.valueOf(ch));
            }
            // Operator
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();

                String temp = ch + op2 + op1;

                stack.push(temp);
            }
        }

        return stack.pop();
    }
}