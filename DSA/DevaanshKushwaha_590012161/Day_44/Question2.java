class Solution {
    public String favoriteElementStatus(int[] nums, int favoriteIndex, int k) {
        int target = nums[favoriteIndex];
        int countGreater = 0;
        int countEqual = 0;

        // Single pass: classify every element relative to target
        for (int num : nums) {
            if (num > target) {
                countGreater++;
            } else if (num == target) {
                countEqual++;
            }
        }

        if (countGreater >= k) {
            return "NEVER";      // group starts at/after k -> safe
        } else if (countGreater + countEqual <= k) {
            return "ALWAYS";     // group ends at/before k -> always cut
        } else {
            return "POSSIBLY";   // k lands inside the tied group
        }
    }
}
