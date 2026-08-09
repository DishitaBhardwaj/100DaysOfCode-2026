
import java.util.Arrays;

public class Question2 {

    // Function to determine if the favorite value is always, never,
    // or possibly removed after sorting descending and removing first k elements.
    //
    // nums          -> the original array
    // favoriteIndex -> 1-indexed position in the ORIGINAL array that points to our favorite value
    // k             -> number of elements removed from the front after descending sort
    public static String checkFavorite(int[] nums, int favoriteIndex, int k) {

        // Step 1: Get the favorite value using the 1-indexed position.
        // Convert to 0-indexed by subtracting 1.
        int favoriteValue = nums[favoriteIndex - 1];

        // Step 2: Count how many elements are strictly greater than the favorite value,
        // and how many elements are exactly equal to it.
        int greaterCount = 0; // elements bigger than favoriteValue
        int equalCount = 0;   // elements equal to favoriteValue

        for (int num : nums) {
            if (num > favoriteValue) {
                greaterCount++;
            } else if (num == favoriteValue) {
                equalCount++;
            }
        }

        // Step 3: Decide the outcome based on where the cutoff (first k removed) falls.
        // Case 1: If there are already k or more elements bigger than favoriteValue,
        // then all k removed elements are bigger ones, so favoriteValue is NEVER removed.
        if (greaterCount >= k) {
            return "NO"; // never removed, always survives
        }

        // Case 2: If even after removing all the bigger elements AND all the equal
        // elements, we still haven't exceeded k, that means every copy of
        // favoriteValue (including ours) gets removed. So it's ALWAYS removed.
        if (greaterCount + equalCount <= k) {
            return "YES"; // always removed
        }

        // Case 3: The cutoff point falls somewhere in the middle of the tied
        // (equal-valued) group. Since sorting doesn't guarantee a specific
        // order among equal elements, our favorite MIGHT be removed or MIGHT survive.
        return "MAYBE"; // possibly removed, possibly not
    }

    // Main method to test the function
    public static void main(String[] args) {

        // Example input
        int[] nums = {4, 2, 1, 3, 5};
        int favoriteIndex = 5; // 1-indexed: points to value 5
        int k = 3;             // remove first 3 elements after descending sort

        // Call the function and print the result
        String result = checkFavorite(nums, favoriteIndex, k);

        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("Favorite value (at index " + favoriteIndex + "): " + nums[favoriteIndex - 1]);
        System.out.println("k = " + k);
        System.out.println("Is favorite always removed? " + result);
    }
}
