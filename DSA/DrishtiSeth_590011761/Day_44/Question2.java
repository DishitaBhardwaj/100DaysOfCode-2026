import java.util.Arrays;

public class Solution {

    public String favouriteNumber(int[] nums, int favoriteIndex, int k) {

        int fav = nums[favoriteIndex - 1];

        int greater = 0;
        int greaterOrEqual = 0;

        for (int num : nums) {
            if (num > fav)
                greater++;

            if (num >= fav)
                greaterOrEqual++;
        }

        if (greater >= k)
            return "NO";

        if (greaterOrEqual <= k)
            return "YES";

        return "MAYBE";
    }
}
