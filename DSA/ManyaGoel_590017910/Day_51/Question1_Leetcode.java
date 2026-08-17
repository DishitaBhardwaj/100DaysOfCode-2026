class Question1_Leetcode {
    public int mostFrequentEven(int[] nums) {
        int[] freq = new int[100001];
        int ans = -1;
        int maxCount = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                freq[num]++;
                int count = freq[num];
                if (count > maxCount) {
                    maxCount = count;
                    ans = num;
                } else if (count == maxCount && num < ans) {
                    ans = num;
                }
            }
        }
        return ans;
    }
}