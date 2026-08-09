import java.util.Stack;

public class Solution {

    public static String postfixToPrefix(String s) {
        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If operand, push it
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } 
            // If operator
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String temp = ch + op1 + op2;
                stack.push(temp);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(postfixToPrefix("AB+CD-*"));      // *+AB-CD
        System.out.println(postfixToPrefix("ABC/-AK/L-*"));  // *-A/BC-/AKL
    }
}
