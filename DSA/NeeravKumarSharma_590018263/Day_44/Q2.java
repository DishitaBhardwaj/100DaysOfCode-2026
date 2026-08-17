public class Q2 {

    public static String isFavoriteRemoved(int[] nums, int favoriteIndex, int k) {
        int favValue = nums[favoriteIndex - 1];
        
        int greaterCount = 0;
        int equalCount = 0;
        
        for (int num : nums) {
            if (num > favValue) {
                greaterCount++;
            } else if (num == favValue) {
                equalCount++;
            }
        }
        
        if (k >= greaterCount + equalCount) {
            return "YES";
        } 
        else if (k <= greaterCount) {
            return "NO";
        } 
        else {
            return "MAYBE";
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3, 5};
        int favoriteIndex = 5; 
        int k = 3;
        
        System.out.println("Output: " + isFavoriteRemoved(nums, favoriteIndex, k));
    }
}