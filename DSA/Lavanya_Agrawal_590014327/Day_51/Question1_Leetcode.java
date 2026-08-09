import java.util.*;

public class Question1_Leetcode {

    public static int mostFrequentEven(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int answer = -1;
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int number = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency ||
                (frequency == maxFrequency && (answer == -1 || number < answer))) {

                maxFrequency = frequency;
                answer = number;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(mostFrequentEven(nums));

        sc.close();
    }
}