//Need to find the most frequent even element

import java.util.*;

class Solution {

    public int mostFrequentEven(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // count only even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        if (freq.isEmpty()) {
            return -1;
        }

        int answer = -1;
        int maxFreq = 0;

        // pick higher frequency, or smaller value if tied
        for (int num : freq.keySet()) {
            int count = freq.get(num);

            if (count > maxFreq || (count == maxFreq && num < answer)) {
                maxFreq = count;
                answer = num;
            }
        }

        return answer;
    }
}