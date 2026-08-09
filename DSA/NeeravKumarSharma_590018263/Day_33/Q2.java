import java.util.Stack;

public class Q2 {

    public static String postfixToPrefix(String s) {
        Stack<String> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            
            if (Character.isLetter(c)) {
                stack.push(String.valueOf(c));
            } 
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                
                String combined = c + op1 + op2;
                stack.push(combined);
            }
        }
        
        return stack.pop();
    }

    public static void main(String[] args) {
        String s = "ABC/-AK/L-*";
        System.out.println("Output: " + postfixToPrefix(s));
    }
}