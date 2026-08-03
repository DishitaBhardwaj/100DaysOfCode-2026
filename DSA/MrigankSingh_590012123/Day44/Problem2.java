public class Problem2 {
    public String favouriteNumber(int[] nums, int favoriteIndex, int k) {
        int favorite = nums[favoriteIndex - 1];
        int greaterCount = 0;
        int greaterOrEqualCount = 0;

        for (int num : nums) {
            if (num > favorite) {
                greaterCount++;
            }
            if (num >= favorite) {
                greaterOrEqualCount++;
            }
        }

        if (greaterOrEqualCount <= k) {
            return "YES";
        }

        if (greaterCount >= k) {
            return "NO";
        }

        return "MAYBE";
    }
}