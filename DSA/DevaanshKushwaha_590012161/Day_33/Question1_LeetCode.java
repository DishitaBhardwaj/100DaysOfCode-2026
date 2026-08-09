class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0; // acts like stack.size() -- tracks nesting level
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) {
                    // not an outermost '(' -> keep it
                    result.append(c);
                }
                depth++; // "push" -> enter a new level
            } else { // c == ')'
                depth--; // "pop" -> exit current level
                if (depth > 0) {
                    // not an outermost ')' -> keep it
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}
