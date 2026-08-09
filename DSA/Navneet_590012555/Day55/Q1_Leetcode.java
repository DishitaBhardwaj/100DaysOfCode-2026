class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] temp = nums.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = temp.length - k; i < temp.length; i++)
            map.put(temp[i], map.getOrDefault(temp[i], 0) + 1);

        int[] ans = new int[k];
        int j = 0;

        for (int x : nums) {
            if (map.getOrDefault(x, 0) > 0) {
                ans[j++] = x;
                map.put(x, map.get(x) - 1);
            }
        }

        return ans;
    }
}