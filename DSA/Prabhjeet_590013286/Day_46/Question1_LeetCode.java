/**
 * LeetCode 349 - Intersection of Two Arrays
 */

//Need to return the unique numbers present in both arrays

import java.util.HashSet;

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> common = new HashSet<>();

        for (int x : nums1) {
            first.add(x);
        }

        // only keep numbers which were also in nums1
        for (int x : nums2) {
            if (first.contains(x)) {
                common.add(x);
            }
        }

        int[] ans = new int[common.size()];
        int i = 0;

        for (int x : common) {
            ans[i++] = x;
        }

        return ans;
    }
}
