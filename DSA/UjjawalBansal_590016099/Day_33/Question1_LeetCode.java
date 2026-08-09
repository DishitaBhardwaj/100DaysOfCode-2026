import java.util.ArrayDeque;
import java.util.Deque;

public class Question1_LeetCode {
    // Method 1 -> By using a stack
    // As this week was about stacks, this approach uses stack to remove the outer parentheses.
    // It takes O(n) time and O(n) extra space.
    public String removeOuterParenthesesByStack(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') count1++;
            else count2++;

            if (count1 != count2) stack.push(ch);
            else {
                while (!stack.isEmpty()) {
                    stack2.push(stack.pop());
                }
                stack2.pop();
                while (!stack2.isEmpty()) {
                    ans.append(stack2.pop());
                }
            }
        }
        return ans.toString();
    }


    // Method 2 -> Optimal Method (By normal string traversing and string building)
    // This is the Optimal way to solve this problem, it uses basic string traversing.
    // It takes O(n) time and O(1) extra space (excluding the output string).
    public String removeOuterParenthesesOptimal(String s) {
        StringBuilder ans = new StringBuilder();
        int a = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (a > 0) {
                    ans.append(ch);
                }
                a++;
            } else {
                if (a > 1) {
                    ans.append(ch);
                }
                a--;
            }
        }
        return ans.toString();
    }
}