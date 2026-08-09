class Solution {
    public String removeOuterParentheses(String s) {
        char l=0;
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray())
        {
            if(c=='(')
            {
                if(l>0) ans.append(c);
                l++;
            }
            else if(c==')')
            {
                l--;
                if(l>0) ans.append(c);
            }

        }
        return ans.toString();
    }
}