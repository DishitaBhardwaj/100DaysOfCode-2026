import java.util.*;

class Question2 {
    public String postfixToPrefix(String s) {
        Stack<String> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String op2 = st.pop();
                String op1 = st.pop();
                st.push(ch + op1 + op2);
            }
        }

        return st.pop();
    }
}