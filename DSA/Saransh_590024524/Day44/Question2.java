package DSA.Saransh_590024524.Day44;

// import java.util.Arrays;

public class Question2 {

    public static String favoriteNumber(int[] nums, int favoriteIndex, int k) {
        int favorite = nums[favoriteIndex - 1];
        int greater = 0;
        int equal = 0;
        for (int num : nums) {
            if (num > favorite) {
                greater++;
            } else if (num == favorite) {
                equal++;
            }
        }
        if (greater + equal <= k) {
            return "YES";
        }
        if (greater >= k) {
            return "NO";
        }
        return "MAYBE";
        }
}

6 5 4 2 2     2+1 <= 2  
            2 >= 2
