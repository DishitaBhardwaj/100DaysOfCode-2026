import java.util.*;

class Solution {
    public String postfixToPrefix(String exp) {
        Stack<String> st = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String op2 = st.pop();
                String op1 = st.pop();

                String temp = ch + op1 + op2;
                st.push(temp);
            }
        }

        return st.pop();
    }
}