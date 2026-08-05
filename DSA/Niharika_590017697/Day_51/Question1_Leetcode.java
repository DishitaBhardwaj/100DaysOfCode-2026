class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
        {
            if (num % 2 == 0) 
            {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int answer = -1;
        int maxFrequency = 0;

        for (int num : map.keySet()) 
        {
            int frequency = map.get(num);
            if (frequency > maxFrequency || (frequency == maxFrequency && num < answer)) 
            {
                maxFrequency = frequency;
                answer = num;
            }
        }

        return answer;
    }
}