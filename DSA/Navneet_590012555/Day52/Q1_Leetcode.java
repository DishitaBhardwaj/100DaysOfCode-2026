class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] f = new int[26];

        for (char c : s.toCharArray())
            f[c - 'a']++;

        int count = 0;

        for (int x : f) {
            if (x != 0) {
                if (count == 0)
                    count = x;
                else if (count != x)
                    return false;
            }
        }

        return true;
    }
}