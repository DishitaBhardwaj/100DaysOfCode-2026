import java.util.*;

public class Main {

    static String favouriteNumber(int[] nums, int favouriteIndex, int k) {
        int favorite = nums[favouriteIndex - 1];

        int greater = 0;
        int equal = 0;

        for (int x : nums) {
            if (x > favorite)
                greater++;
            else if (x == favorite)
                equal++;
        }

        if (greater >= k)
            return "NO";

        if (greater + equal <= k)
            return "YES";

        return "MAYBE";
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3, 5};
        int favouriteIndex = 5;
        int k = 3;

        System.out.println(favouriteNumber(nums, favouriteIndex, k));
    }
}