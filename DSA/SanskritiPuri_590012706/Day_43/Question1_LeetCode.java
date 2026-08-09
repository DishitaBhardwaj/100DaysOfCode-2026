class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;      // pointer for last real element in nums1
        int j = n - 1;      // pointer for last element in nums2
        int k = m + n - 1;  // pointer for last position in nums1 (write position)

        // Merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has elements left, copy them
        // (if nums1 still has elements left, they're already in the correct spot)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
