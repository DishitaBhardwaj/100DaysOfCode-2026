public class Question1_LeetCode {
    public static int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxF = 0;
        int total = 0;
        
        for (int n : nums) {
            freq[n]++;
            
            if (freq[n] > maxF) {
                maxF = freq[n];
                total = maxF;
            } 
            else if (freq[n] == maxF) {
                total += maxF;
            }
        }
        return total;
    }
}
