//Need to count all good substrings of length three

class Solution {

    public int countGoodSubstrings(String s) {

        int count = 0;

        // check every substring of length 3
        for (int i = 0; i <= s.length() - 3; i++) {

            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            // all three characters must be different
            if (a != b && b != c && a != c) {
                count++;
            }
        }

        return count;
    }
}