public class Question2 {

    public static String favouriteNumber(int[] nums, int favoriteIndex, int k) {
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
            return "YES";
        } else if (greater + equal <= k) {
            return "NO";
        } else {
            return "MAYBE";
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 2, 3};
        System.out.println(favouriteNumber(nums, 2, 2)); 

    }
}