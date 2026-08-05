import java.util.HashMap;
import java.util.Map;

class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int mostFreq = -1;
        int maxCount = 0;
        
        for (int num : nums) {
            if (num % 2 == 0) {
                int count = counts.getOrDefault(num, 0) + 1;
                counts.put(num, count);
                
                if (count > maxCount) {
                    maxCount = count;
                    mostFreq = num;
                } 
                else if (count == maxCount && num < mostFreq) {
                    mostFreq = num;
                }
            }
        }
        
        return mostFreq;
    }
}