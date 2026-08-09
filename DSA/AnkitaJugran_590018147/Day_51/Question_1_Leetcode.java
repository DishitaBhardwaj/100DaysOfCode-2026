class Solution {
    public int mostFrequentEven(int[] nums) {

        //creating hashmap to store frequency of even num
        HashMap<Integer, Integer> freq = new HashMap<>();

        int maxFreq = 0;
        int ans = -1;

        for (int num : nums) {

            if (num % 2 == 0) {

                int count = freq.getOrDefault(num, 0) + 1;
                freq.put(num, count);

                if (count > maxFreq) {
                    maxFreq = count;
                    ans = num;
                    
                } else if (count == maxFreq && (ans == -1 || num < ans)) {
                    ans = num;
                }
            }
        }

        return ans;
    }
}