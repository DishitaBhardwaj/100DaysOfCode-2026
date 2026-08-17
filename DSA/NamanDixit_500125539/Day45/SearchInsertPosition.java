
class Question1_leetcode {

    // Function to find the index of target, or the index where it should be inserted
    public int searchInsert(int[] nums, int target) {

        // Two pointers marking the current search range
        int left = 0;
        int right = nums.length - 1;

        // Standard binary search loop: keep narrowing the range while it's valid
        while (left <= right) {

            // Find the middle index of the current range
            // (using left + (right-left)/2 instead of (left+right)/2 to avoid overflow)
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // Found the target exactly, return its index
                return mid;
            } else if (nums[mid] < target) {
                // Target is bigger than the middle element,
                // so it must be somewhere in the right half.
                // Move left pointer past mid.
                left = mid + 1;
            } else {
                // Target is smaller than the middle element,
                // so it must be somewhere in the left half.
                // Move right pointer just before mid.
                right = mid - 1;
            }
        }

        // If we exit the loop, the target was NOT found in the array.
        // At this point, "left" has naturally moved to the exact position
        // where the target should be inserted to keep the array sorted.
        return left;
    }
}
