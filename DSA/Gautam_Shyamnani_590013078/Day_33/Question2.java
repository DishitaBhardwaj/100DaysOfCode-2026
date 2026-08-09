
import java.util.Stack;

public class Question2 {

    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    // Function to convert postfix to prefix
    public static String postfixToPrefix(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!isOperator(c)) {
                st.push(String.valueOf(c));
            } 
            else {
                String op1 = st.pop();
                String op2 = st.pop();

                String temp = c + op2 + op1;
                st.push(temp);
            }
        }

        return st.peek();
    }

    public static void main(String[] args) {
        String s1 = "AB+CD-*";
        String s2 = "ABC/-AK/L-*";

        System.out.println(postfixToPrefix(s1));
        System.out.println(postfixToPrefix(s2));
    }
}