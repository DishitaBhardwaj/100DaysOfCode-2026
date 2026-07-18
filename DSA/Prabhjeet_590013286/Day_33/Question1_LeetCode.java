/**
 * LeetCode 1021 - Remove Outermost Parentheses
 * https://leetcode.com/problems/remove-outermost-parentheses/
 */

//Need to remove the outer bracket from every primitive part

class Solution {

    public String removeOuterParentheses(String s) {

        StringBuilder ans = new StringBuilder();

        int open = 0;

        for (char ch : s.toCharArray()) {

            // skip the first opening bracket
            if (ch == '(') {

                if (open > 0) {
                    ans.append(ch);
                }

                open++;
            }
            else {

                open--;

                // skip the last closing bracket
                if (open > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}