class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap <Integer, Integer> hm = new HashMap <> ();
        for (int i = 0 ; i < nums.length ; i++ ) {
            if (nums[i]%2==0) {
                hm.put(nums[i], hm.getOrDefault (nums[i],0) + 1);
                
            }
        }
        if (hm.size() == 0 ) {
            return -1;
        }
        int maxKey = -1;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry <Integer , Integer> entry : hm.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
            else if (entry.getValue() == maxValue ) {
                if (maxKey > entry.getKey()) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
        }
        return maxKey;
        
        

        
    }
}