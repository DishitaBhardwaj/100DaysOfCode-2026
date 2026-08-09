class Solution {
    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = stack.length();

            if (len > 0) {
                char top = stack.charAt(len - 1);

                if ((top == 'A' && ch == 'B') ||
                    (top == 'C' && ch == 'D')) {
                    stack.deleteCharAt(len - 1);
                    continue;
                }
            }

            stack.append(ch);
        }

        return stack.length();
    }
}