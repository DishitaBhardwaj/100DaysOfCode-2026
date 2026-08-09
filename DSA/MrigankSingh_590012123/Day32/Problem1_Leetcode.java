public class Problem1_Leetcode {
    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int length = stack.length();

            if (length > 0 && ((stack.charAt(length - 1) == 'A' && current == 'B') || (stack.charAt(length - 1) == 'C' && current == 'D'))) {
                stack.deleteCharAt(length - 1);
            } else {
                stack.append(current);
            }
        }

        return stack.length();
    }
}