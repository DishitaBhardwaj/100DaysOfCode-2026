class Solution {
    public int mostFrequentEven(int[] nums) {
        // Map: even number -> frequency count
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            if (num % 2 == 0) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }
        
        int result = -1;
        int maxCount = 0;
        
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            
            // Update if higher frequency, OR same frequency but smaller number
            if (count > maxCount || (count == maxCount && num < result)) {
                maxCount = count;
                result = num;
            }
        }
        
        return result;
    }
}
