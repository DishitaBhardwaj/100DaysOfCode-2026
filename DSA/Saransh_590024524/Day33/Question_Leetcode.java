package DSA.Saransh_590024524.Day33;

public class Question_Leetcode {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) result.append(c);
                depth++;
            } else {
                depth--;
                if (depth > 0) result.append(c);
            }
        }
        return result.toString();
    }
}
