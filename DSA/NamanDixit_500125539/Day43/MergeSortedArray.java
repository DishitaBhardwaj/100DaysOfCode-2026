
class Question1_leetocde {

    // Function to merge nums2 into nums1 in-place
    // m = number of actual elements in nums1 (rest are placeholder zeros)
    // n = number of elements in nums2
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Pointer for the last real element in nums1
        int i = m - 1;

        // Pointer for the last element in nums2
        int j = n - 1;

        // Pointer for the last position in nums1 (end of the array)
        int k = m + n - 1;

        // Step 1: Compare elements from the back of both arrays,
        // and place the larger one at the back of nums1.
        // We move backwards so we never overwrite a value
        // in nums1 that we still need to read later.
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]; // nums1's element is bigger, place it
                i--;                 // move nums1 pointer left
            } else {
                nums1[k] = nums2[j]; // nums2's element is bigger (or equal), place it
                j--;                 // move nums2 pointer left
            }
            k--; // move the fill pointer left after placing a value
        }

        // Step 2: If any elements remain in nums2, copy them over.
        // (If nums1 still has leftover elements, they are already
        // in their correct sorted position, so nothing more is needed.)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
