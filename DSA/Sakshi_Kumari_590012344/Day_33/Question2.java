import java.util.Stack;

class Solution {
    public String postToPre(String s) {
        Stack<String> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String right = st.pop();
                String left = st.pop();

                String exp = ch + left + right;
                st.push(exp);
            }
        }

        return st.pop();
    }
}
