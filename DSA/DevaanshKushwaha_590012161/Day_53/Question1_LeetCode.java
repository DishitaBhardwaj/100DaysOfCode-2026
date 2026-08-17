class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        
        // Slide a window of size 3 across the string
        for (int i = 0; i + 2 < s.length(); i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            
            // "Good" means all three characters are different
            if (a != b && b != c && a != c) {
                count++;
            }
        }
        
        return count;
    }
}
