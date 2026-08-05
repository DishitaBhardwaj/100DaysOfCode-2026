class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = -1;
        int max = 0;

        for (int x : nums) {
            if (x % 2 == 0) {
                map.put(x, map.getOrDefault(x, 0) + 1);

                int f = map.get(x);

                if (f > max || (f == max && (ans == -1 || x < ans))) {
                    max = f;
                    ans = x;
                }
            }
        }

        return ans;
    }
}