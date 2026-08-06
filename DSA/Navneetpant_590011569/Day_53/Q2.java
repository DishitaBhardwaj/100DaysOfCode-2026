class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return result;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            window[s.charAt(i) - 'a']++;

            if (i >= m) {
                window[s.charAt(i - m) - 'a']--;
            }

            if (i >= m - 1 && Arrays.equals(window, need)) {
                result.add(i - m + 1);
            }
        }

        return result;
    }
}