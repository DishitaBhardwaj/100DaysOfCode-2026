class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        // traverse through array and store frequency in hashmap
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Get the frequency of the first character
        int expected = freq.values().iterator().next();

        // Check if all frequencies are equal
        for (int count : freq.values()) {
            if (count != expected) {
                return false;
            }
        }

        return true;
    }
}