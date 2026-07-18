class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int d = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (d > 0) {
                    ans.append(ch);
                }
                d++;
            } else {
                d--;
                if (d > 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}