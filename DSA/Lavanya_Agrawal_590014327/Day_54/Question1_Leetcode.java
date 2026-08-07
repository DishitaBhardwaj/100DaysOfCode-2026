import java.util.*;

public class Question1_Leetcode {

    public static int maxFrequencyElements(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;

        for (int frequency : map.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        int total = 0;

        for (int frequency : map.values()) {
            if (frequency == maxFrequency) {
                total += frequency;
            }
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(maxFrequencyElements(nums));

        sc.close();
    }
}