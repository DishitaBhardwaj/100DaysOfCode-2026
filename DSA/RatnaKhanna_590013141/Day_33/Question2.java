import java.util.*;

class Main {

    public static String postfixToPrefix(String s) {

        Stack<String> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If operand
            if (Character.isLetter(ch)) {
                st.push(String.valueOf(ch));
            }
            // If operator
            else {
                String op2 = st.pop();
                String op1 = st.pop();

                String exp = ch + op1 + op2;
                st.push(exp);
            }
        }

        return st.peek();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String s = sc.next();

        System.out.println("Prefix Expression: " + postfixToPrefix(s));

        sc.close();
    }
}
