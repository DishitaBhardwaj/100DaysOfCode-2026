class Solution {
    public int countGoodSubstrings(String s) {
        int c = 0;
        for (int i = 0; i + 2 < s.length(); i++)
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) 
                c++;
        return c;
    }
}