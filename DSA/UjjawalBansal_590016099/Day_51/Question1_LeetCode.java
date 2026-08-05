import java.util.HashMap;
import java.util.Map;

public class Question1_LeetCode {
    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        int mostFreq = -1;
        int maxFreq = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                int currentFreq = freq.getOrDefault(num, 0) + 1;
                freq.put(num, currentFreq);

                if (currentFreq > maxFreq) {
                    maxFreq = currentFreq;
                    mostFreq = num;
                } 
                else if (currentFreq == maxFreq) {
                    mostFreq = Math.min(mostFreq, num);
                }
            }
        }

        return mostFreq;
    }
}
