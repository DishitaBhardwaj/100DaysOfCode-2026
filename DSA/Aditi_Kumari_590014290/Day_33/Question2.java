/*Convert a valid postfix expression consisting of uppercase letters (A–Z) as operands and the operators +,-,*,/ (no parentheses, whitespace, or invalid characters) into its equivalent prefix expression using a stack based approach.

Example
Input:s = "ABC/-AK/L-*". Output:"*-A/BC-/AKL" */
package Day_33;

import java.util.Stack;

public class Question2 {
    public static String postfixToPrefix(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                stack.push(String.valueOf(ch));
            }
            else {
                String op1 = stack.pop();   
                String op2 = stack.pop();   
                String exp = ch + op2 + op1;
                stack.push(exp);
            }
        }
        return stack.pop();
    
}
}
