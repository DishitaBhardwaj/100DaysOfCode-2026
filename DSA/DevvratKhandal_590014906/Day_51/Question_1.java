import java.util.*;

public class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = -1;
        int maxFreq = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                int freq = map.getOrDefault(num, 0) + 1;
                map.put(num, freq);

                if (freq > maxFreq || (freq == maxFreq && (ans == -1 || num < ans))) {
                    maxFreq = freq;
                    ans = num;
                }
            }
        }

        System.out.println("Most Frequent Even Element: " + ans);
    }
}