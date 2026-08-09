//Need to find the element with the highest frequency, and if tied keep the smaller one

import java.util.*;

class Solution {

    public int maxFrequencyElements(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        int maxFreq = 0;

        // count frequency and keep track of the maximum one
        for (int num : nums) {
            int f = freq.getOrDefault(num, 0) + 1;
            freq.put(num, f);
            maxFreq = Math.max(maxFreq, f);
        }

        int sum = 0;

        // add frequencies of all elements that match max frequency
        for (int f : freq.values()) {
            if (f == maxFreq) {
                sum += f;
            }
        }

        return sum;
    }
}