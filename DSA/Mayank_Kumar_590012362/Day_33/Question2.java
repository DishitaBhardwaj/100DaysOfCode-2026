import java.util.Stack;
class Question2 {
    static String postToPre(String s) {
        Stack<String> s1 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) s1.push(c + "");
            else {
                String b = s1.pop(), a = s1.pop();
                s1.push(c + a + b);
            }
        } return s1.pop();
    }
}