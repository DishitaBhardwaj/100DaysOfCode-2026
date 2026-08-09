package Day_33;

import java.util.*;
class Solution {
    public String removeOuterParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (!stack.isEmpty()) {
                    ans.append(ch);
                }
                stack.push(ch);
            } else {

                if (stack.size() > 1) {
                    ans.append(ch);
                }

                stack.pop();
            }
        }
        return ans.toString();
    }
}