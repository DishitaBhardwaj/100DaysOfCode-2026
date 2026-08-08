class Question1_Leetcode {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0, ans = 0;
        for (int num : nums) {
            int f = ++freq[num];
            if (f >= maxFreq) {
                if (f > maxFreq) {
                    maxFreq = f;
                    ans = f;
                } else {
                    ans += f;
                }
            }
        }
        return ans;
    }
}