/*Favourite Number
Explanation
Write an efficient function to determine if a favorite element is always, never, or possibly removed after sorting an array in descending order and removing the first k elements.

Example
Input: nums = [4, 2, 1, 3, 5], favoriteIndex = 5, k = 3. Output: "YES". */
package Day_44;
public class Question2 {
    public String chooseFavorite(int[] nums, int favoriteIndex, int k) {

        int fav = nums[favoriteIndex - 1];

        int greater = 0;
        int equal = 0;

        for (int num : nums) {
            if (num > fav) {
                greater++;
            } else if (num == fav) {
                equal++;
            }
        }

        if (greater >= k) {
            return "NO";
        }
        if (greater + equal <= k) {
            return "YES";
        }
        return "MAYBE";
    }
}
