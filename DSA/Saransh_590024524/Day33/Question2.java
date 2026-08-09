package DSA.Saransh_590024524.Day33;

import java.util.Stack;

public class Question2 {
    public String postfixToPrefix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            }
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String temp = ch + op1 + op2;
                stack.push(temp);
            }
        }

        return stack.pop();
    }
}
