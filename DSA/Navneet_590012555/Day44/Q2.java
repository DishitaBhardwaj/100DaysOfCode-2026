class Solution {
    public String favoriteNumber(int[] nums, int favoriteIndex, int k) {
        int fav = nums[favoriteIndex - 1];

        int greater = 0, equal = 0;

        for (int x : nums) {
            if (x > fav)
                greater++;
            else if (x == fav)
                equal++;
        }

        if (greater >= k)
            return "NO";
        else if (greater + equal <= k)
            return "YES";
        else
            return "MAYBE";
    }
}