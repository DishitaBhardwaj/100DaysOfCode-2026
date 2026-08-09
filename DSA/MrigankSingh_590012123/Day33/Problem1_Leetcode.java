public class Problem1_Leetcode {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(') {
                if (balance > 0) {
                    result.append(current);
                }
                balance++;
            } else {
                balance--;
                if (balance > 0) {
                    result.append(current);
                }
            }
        }

        return result.toString();
    }
}