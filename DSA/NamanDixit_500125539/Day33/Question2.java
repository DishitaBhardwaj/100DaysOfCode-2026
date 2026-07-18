
import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    // Function to convert postfix to prefix
    public static String postfixToPrefix(String postfix) {

        // Create a stack of strings
        Stack<String> stack = new Stack<>();

        // Traverse every character of postfix expression
        for (int i = 0; i < postfix.length(); i++) {

            // Current character
            char ch = postfix.charAt(i);

            // If it is an operand (A-Z)
            if (Character.isLetter(ch)) {

                // Push operand as string
                stack.push(ch + "");
            } // Otherwise it is an operator
            else {

                // Pop first operand
                String operand1 = stack.pop();

                // Pop second operand
                String operand2 = stack.pop();

                // Create prefix expression
                String prefix = ch + operand2 + operand1;

                // Push new expression
                stack.push(prefix);
            }
        }

        // Final prefix expression
        return stack.pop();
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Input postfix expression
        System.out.print("Enter postfix expression: ");
        String postfix = sc.nextLine();

        // Convert to prefix
        String prefix = postfixToPrefix(postfix);

        // Print answer
        System.out.println("Prefix Expression = " + prefix);

        // Close scanner
        sc.close();
    }
}
