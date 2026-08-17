package DSA.Mugdha_590015431.Day_44;
import java.util.HashSet;

public class Question1_LeetCode {

    public static boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (n == 2) return true;

        if ((max - min) % (n - 1) != 0)
            return false;

        int diff = (max - min) / (n - 1);

        if (diff == 0) {
            for (int num : arr) {
                if (num != min)
                    return false;
            }
            return true;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if ((num - min) % diff != 0)
                return false;

            if (!set.add(num))
                return false;
        }

        return set.size() == n;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 1};
        int[] arr2 = {1, 2, 4};

        System.out.println(canMakeArithmeticProgression(arr1)); // true
        System.out.println(canMakeArithmeticProgression(arr2)); // false
    }
}