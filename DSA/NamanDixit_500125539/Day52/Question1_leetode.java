
class Question1_leetcode {

    // Function to check if every character in the string appears the same number of times
    public boolean areOccurrencesEqual(String s) {

        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency[c - 'a']++;
        }

        int expectedCount = -1;

        for (int count : frequency) {
            if (count > 0) {
                if (expectedCount == -1) {
                    expectedCount = count;
                } else if (count != expectedCount) {
                    return false;
                }
            }
        }

        return true;
    }
}
