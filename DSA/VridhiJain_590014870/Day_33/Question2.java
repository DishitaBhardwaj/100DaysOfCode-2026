import java.util.*;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String b = stack.pop();
                String a = stack.pop();
                stack.push(ch + a + b);
            }
        }
        System.out.println(stack.pop());
    }
}