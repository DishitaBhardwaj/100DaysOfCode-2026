class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) a[c - 'a']++;
        int f = 0;
        for (int x : a) {
            if (x == 0) continue;
            if (f == 0) f = x;
            else if (x != f) return false;
        } return true;
    }
}