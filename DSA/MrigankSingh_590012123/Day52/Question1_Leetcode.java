public class Question1_Leetcode {
    public boolean areOccurrencesEqual(String s) {
        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        int target = 0;
        for (int count : frequency) {
            if (count == 0) {
                continue;
            }

            if (target == 0) {
                target = count;
            } else if (count != target) {
                return false;
            }
        }

        return true;
    }
}