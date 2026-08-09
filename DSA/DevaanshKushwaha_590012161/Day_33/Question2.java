class Solution {
    public String postfixToPrefix(String s) {
        Deque<String> stack = new ArrayDeque<>(); // top of stack = most recently pushed string
        
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                // operand -> push as a single-character string
                stack.push(String.valueOf(c));
            } else {
                // operator -> pop two operands and combine into prefix form
                String operand2 = stack.pop(); // first pop = right operand (came second in postfix)
                String operand1 = stack.pop(); // second pop = left operand (came first in postfix)
                
                String combined = c + operand1 + operand2; // prefix: operator + left + right
                stack.push(combined);
            }
        }
        
        return stack.pop(); // the single remaining string is the full prefix expression
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.postfixToPrefix("ABC/-AK/L-*")); // *-A/BC-/AKL
    }
}
