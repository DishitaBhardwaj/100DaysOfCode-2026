class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int answer = -1;
        int maxFreq = 0;

        for (int num : map.keySet()) {
            int freq = map.get(num);

            if (freq > maxFreq || (freq == maxFreq && (answer == -1 || num < answer))) {
                maxFreq = freq;
                answer = num;
            }
        }

        return answer;
        
    }
}
