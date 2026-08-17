//Need to check if every character appears the same number of times

import java.util.*;

class Solution {

    public boolean areOccurrencesEqual(String s) {

        HashMap<Character, Integer> freq = new HashMap<>();

        // count every character
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int count = -1;

        // all frequencies should match
        for (int value : freq.values()) {

            if (count == -1) {
                count = value;
            } else if (count != value) {
                return false;
            }
        }

        return true;
    }
}