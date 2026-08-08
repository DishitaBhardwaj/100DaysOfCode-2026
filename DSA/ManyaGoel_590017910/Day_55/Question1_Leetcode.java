class Question1_Leetcode {
    public int[] maxSubsequence(int[] nums, int k) {
        int offset = 100000;
        int[] freq = new int[200001];

        for (int num : nums) {
            freq[num + offset]++;
        }

        int left = k;
        int limit = 0;

        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] >= left) {
                limit = i - offset;
                break;
            }
            left -= freq[i];
        }

        int bigger = 0;
        for (int num : nums) {
            if (num > limit) {
                bigger++;
            }
        }

        int need = k - bigger;
        int[] ans = new int[k];
        int idx = 0;

        for (int num : nums) {
            if (num > limit) {
                ans[idx++] = num;
            } else if (num == limit && need > 0) {
                ans[idx++] = num;
                need--;
            }
        }

        return ans;
    }
}