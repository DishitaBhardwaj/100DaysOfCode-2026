package Day_51;
import java.util.*;
class Solution {
    public int mostFrequentEven(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;
        int maxFreq = 0;

        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (freq > maxFreq) {
                maxFreq = freq;
                ans = key;
            } else if (freq == maxFreq && key < ans) {
                ans = key;
            }
        }

        return ans;
    }
}