
class Question1_leetcode {

    // Function to find a subsequence of length k with the largest possible sum,
    // while preserving the original relative order of elements.
    public int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> nums[b] - nums[a]);

        Integer[] topKIndices = Arrays.copyOfRange(indices, 0, k);

        Arrays.sort(topKIndices);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[topKIndices[i]];
        }

        return result;
    }
}
