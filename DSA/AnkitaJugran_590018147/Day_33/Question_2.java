import java.util.Stack;

public class PostfixToPrefix {

    public static void main( String[] args ) {

        String postfix = "ABC/-AK/L-*";

        String prefix = convertPostfixToPrefix(postfix);

        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + prefix);
    }

    public static String convertPostfixToPrefix(String postfix) {

        Stack<String> stack = new Stack<>();

        for ( char c : postfix.toCharArray() ) {

            if ( Character.isLetter(c) ) {

                stack.push(c + "");

            } else {

                String operand2 = stack.pop();
                String operand1 = stack.pop();

                String expression = c + operand1 + operand2;
                stack.push(expression);
            }
        }

        return stack.pop();
    }
    
}